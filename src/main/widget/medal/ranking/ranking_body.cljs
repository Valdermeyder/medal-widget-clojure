(ns widget.medal.ranking.ranking-body
  (:require [widget.medal.ranking.ranking-row :refer [ranking-row]]))

(defn ranking-body
  []
  [ranking-row {:ranking 1 :code "UA"}])
