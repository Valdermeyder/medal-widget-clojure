(ns widget.test.setup-test
  (:require [cljs.test :refer [async]]
            [cljs.core.async :refer [go timeout <!]]
            ["msw" :as msw]))

(def msw-worker (msw/setupWorker
                  (.get msw/rest
                        "/json/ranking.json"
                        (fn [_ res ctx]
                          (res
                            (.status ctx 200)
                            (.json ctx (clj->js [{:code   "USA"
                                                  :gold   1
                                                  :silver 1
                                                  :bronze 1}])))))))

(defn msw-worker-start []
  (async done
    (.start msw-worker)
    ;sometimes msw-worker is started after tests are executed
    (go (<! (timeout 1000))
        (done))))

(defn msw-worker-stop []
  (.stop msw-worker))
