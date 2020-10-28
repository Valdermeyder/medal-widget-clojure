(ns widget.medal.ranking.ranking-header
  (:require [widget.medal.medals :refer [medalKeys]]))

(def medal-header-keys (concat medalKeys [:total]))

(def medal-header-labels {:total "Total"
                          :gold "Gold"
                          :silver "Silver"
                          :bronze "Bronze"})

(defn ranking-header
  []
  [:tr
   [:th {:key "ranking" :aria-label "Ranking"}]
   [:th {:key "county-flag" :aria-label "Country flag"}]
   [:th {:key "county-code" :aria-label "Country code"}]
   (map (fn
          [key]
          [:th {:key key} (key medal-header-labels)])
        medal-header-keys)
   ])
