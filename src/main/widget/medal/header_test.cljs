(ns widget.medal.header-test
  (:require [cljs.test :refer [deftest testing is use-fixtures run-tests]]
            [reagent.core :as r]
            ["@testing-library/react" :as testing-library]
            [widget.medal.header :refer [header]]))

(use-fixtures :each
              {:after testing-library/cleanup})

(deftest test-header
  (testing "A header saying 'MEDAL WIDGET' is shown to user"
    (is
      (=
        "MEDAL WIDGET"
        (-> (r/as-element [header])
            (testing-library/render)
            (.getByText "MEDAL WIDGET")
            (.-innerHTML))))))
