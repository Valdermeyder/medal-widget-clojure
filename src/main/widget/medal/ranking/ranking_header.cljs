(ns widget.medal.ranking.ranking-header
  (:require [widget.medal.medals :refer [medalKeys]]
            [widget.medal.countries :refer [order]]))

(def medal-header-keys (concat medalKeys [:total]))

(defn medal-dot [{:keys [kind]}]
  [:span {:class (str "medal-dot medal-dot-" kind)
          :aria-label kind}])

(def medal-header-labels {:total  "Total"
                          :gold   [medal-dot {:kind "gold"}]
                          :silver [medal-dot {:kind "silver"}]
                          :bronze [medal-dot {:kind "bronze"}]})

(defn ranking-header
  []
  [:tr
   [:th {:key "ranking" :aria-label "Ranking"}]
   [:th {:key "county-flag" :aria-label "Country flag"}]
   [:th.country-code-cell {:key "county-code" :aria-label "Country code"}]
   (doall (map (fn
          [key]
          [:th {:key      key
                :on-click #(reset! order key)
                :class (when (= @order key) "column-header-active")} (key medal-header-labels)])
        medal-header-keys))])
