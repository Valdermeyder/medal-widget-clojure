(ns widget.medal.ranking.table
  (:require [widget.medal.ranking.ranking-header :refer [ranking-header]]
            [widget.medal.ranking.ranking-body :refer [ranking-body]]))

(defn ranking-table
  [{:keys [order]}]
  [:table
   [:thead
    [ranking-header {:order order}]]
   [:tbody
    [ranking-body {:order order}]]])
