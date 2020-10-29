(ns widget.medal.app
  (:require [widget.medal.header :refer [header]]
            [widget.medal.ranking.ranking :refer [ranking]]))

(defn app
  [{:keys [order]}]
  [:<>
   [header]
   [:main
    [ranking {:order order}]]])

