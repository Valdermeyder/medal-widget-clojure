(ns widget.medal.header-test
  (:require [cljs.test :refer [deftest testing is use-fixtures]]
            [reagent.core :as r]
            ["@testing-library/react" :refer [cleanup render screen]]
            [widget.medal.header :refer [header]]))

(use-fixtures :each
              {:after cleanup})

(deftest test-header
  (testing "A header saying 'MEDAL WIDGET' is shown to user"
    (-> (r/as-element [header])
        (render))
    (is
      (=
        "MEDAL WIDGET"
        (-> (.getByText screen "MEDAL WIDGET")
            (.-innerHTML))))))
