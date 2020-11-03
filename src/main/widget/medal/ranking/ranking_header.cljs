(ns widget.medal.ranking.ranking-header
  (:require [re-frame.core :as rf]
            [widget.medal.medals :refer [medalKeys]]))

(def medal-header-keys (concat medalKeys [:total]))

(defn medal-dot [{:keys [kind]}]
  [:span.height-25.width-25.border-radius-50.display-inline-block {:class      (str "background-color-" kind)
                                                                   :aria-label kind}])

(def medal-header-labels {:total  "Total"
                          :gold   [medal-dot {:kind "gold"}]
                          :silver [medal-dot {:kind "silver"}]
                          :bronze [medal-dot {:kind "bronze"}]})

(defn ranking-header-cell [props children]
  [:th.border-top.border-bottom-large.padding-8-15.color-dark-grey props children])

(defn ranking-header-empty-cell [{:keys [class] :as props} children]
  [ranking-header-cell (merge props {:class (str "border-top-color-transparent" (if (identity class) (str " " class) ""))}) children])

(defn ranking-header
  []
  [:tr
   [ranking-header-empty-cell {:key "ranking" :aria-label "Ranking"}]
   [ranking-header-empty-cell {:key "county-flag" :aria-label "Country flag"}]
   [ranking-header-empty-cell {:key "county-code" :aria-label "Country code" :class "min-width-large"}]
   (doall (map (fn
                 [key]
                 [ranking-header-cell {:key      key
                                       :on-click #(rf/dispatch [:order key])
                                       :class    (if (= @(rf/subscribe [:order]) key)
                                                   "border-top-color-grey"
                                                   "border-top-color-transparent")}
                  (key medal-header-labels)])
               medal-header-keys))])
