(ns widget.medal.ranking.ranking-row)

(defn ranking-row
  [{:keys [ranking code gold silver bronze total]}]
  [:tr
   [:td {:key "ranking"} ranking]
   [:td {:key "country-flag"} (str code " flag")]
   [:td {:key "country-code"}
    [:b code]]
   [:td {:key "gold"} gold]
   [:td {:key "silver"} silver]
   [:td {:key "bronze"} bronze]
   [:td {:key "total"} total]
   ])
