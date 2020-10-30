(ns widget.medal.ranking.ranking-row)

(defn ranking-row
  [{:keys [ranking code gold silver bronze total flag-position]}]
  [:tr
   [:td.ranking-cell {:key "ranking"} ranking]
   [:td {:key "country-flag"}
    [:span.flag-image {:aria-label (str code " flag")
                       :style { :background-position flag-position }}]]
   [:td {:key "country-code"}
    [:b code]]
   [:td.score-cell {:key "gold"} gold]
   [:td.score-cell {:key "silver"} silver]
   [:td.score-cell {:key "bronze"} bronze]
   [:td.score-cell {:key "total"}
    [:b.total-score-cell total]]])
