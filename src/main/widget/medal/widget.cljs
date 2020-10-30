(ns widget.medal.widget
  (:require [widget.medal.header :refer [header]]
            [widget.medal.ranking.ranking :refer [ranking]]))

(defn widget
  []
  [:div.medal-widget
   [header]
   [:main
    [ranking]]])

