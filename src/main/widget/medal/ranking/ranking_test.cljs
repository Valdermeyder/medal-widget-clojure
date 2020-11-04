(ns widget.medal.ranking.ranking-test
  (:require [cljs.test :refer [deftest testing is use-fixtures async]]
            [cljs.core.async :refer [go timeout <!]]
            [cljs.core.async.interop :refer-macros [<p!]]
            [reagent.core :as r]
            ["@testing-library/react" :refer [cleanup render screen]]
            ["msw" :as msw]
            [widget.medal.ranking.ranking :as ranking]
            [widget.test.setup-test :refer [msw-worker-start msw-worker-stop msw-worker]]))

(defn after-each-test []
  (cleanup)
  (.resetHandlers msw-worker))

(use-fixtures :each
              {:after after-each-test})

(use-fixtures :once
              {:before msw-worker-start
               :after  msw-worker-stop})

(deftest ranking-test-loader
  (testing "A loader is shown to user"
    (-> (r/as-element [ranking/ranking])
        (render))
    (is
      (=
        "No data yet..."
        (-> (.getByText screen "No data yet...")
            (.-innerHTML))))))

(deftest ranking-test-error
  (testing "An error messaged is shown to user"
    (.use msw-worker
          (.get msw/rest
                "/json/ranking.json"
                (fn [_ res ctx]
                  (res (.status ctx 500)))))
    (-> (r/as-element [ranking/ranking])
        (render))
    (let [text "Ranking is not available, please check the connection."
          element (.findByText screen text)]
      (async done
        (go
          (is (= text (.-innerText (<p! element))))
          (done))))))

(deftest ranking-test-success
  (testing "A country from ranking is shown to user"
    (-> (r/as-element [ranking/ranking])
        (render))
    (let [country "USA"
          element (.findByText screen country)]
      (async done
        (go
          (is (= country (.-innerText (<p! element))))
          (done))))))
