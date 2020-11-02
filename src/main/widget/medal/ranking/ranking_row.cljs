(ns widget.medal.ranking.ranking-row)

(defn ranking-cell [props children]
  [:td.padding-10.color-grey props children])

(defn ranking-score-cell [props children]
  [ranking-cell (merge {:class "text-align-center"} props) children])

(defn ranking-row
  [{:keys [ranking code gold silver bronze total flag-position]}]
  [:tr.border-bottom-small
   [ranking-cell {:key "ranking", :class "text-align-right"} ranking]
   [ranking-cell {:key "country-flag"}
    [:span.background-repeat-no.height-17.width-30.display-inline-block.background-image-flag
     {:aria-label (str code " flag")
      :style      {:background-position flag-position}}]]
   [ranking-cell {:key "country-code"}
    [:b code]]
   [ranking-score-cell {:key "gold"} gold]
   [ranking-score-cell {:key "silver"} silver]
   [ranking-score-cell {:key "bronze"} bronze]
   [ranking-score-cell {:key "total"}
    [:b.color-dark-grey total]]])
