(ns widget.medal.ranking.table
  (:require [widget.medal.ranking.ranking-header :refer [ranking-header]]
            [widget.medal.ranking.ranking-body :refer [ranking-body]]))

(defn ranking-table []
  [:table.border-collapse
   [:thead
    [ranking-header]]
   [:tbody
    [ranking-body]]])
