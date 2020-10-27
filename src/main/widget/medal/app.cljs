(ns widget.medal.app
  (:require [widget.medal.header :refer [header]]
            [widget.medal.ranking.table :refer [ranking-table]]))

(defn app
  [{:keys [order]}]
  [:<>
   [header]
   [:main
    [ranking-table {:order order}]]])

