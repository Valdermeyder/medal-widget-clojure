(ns widget.medal.ranking.ranking
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [ajax.core :refer [GET]]
            [widget.medal.ranking.ranking-table :refer [ranking-table]]
            [widget.medal.ranking.countries]
            [widget.medal.ranking.order]))

(defn fetch-countries! [fetch-error]
  (reset! fetch-error false)
  (GET "/json/ranking.json"
       {:response-format :json
        :keywords?       true
        :handler         #(rf/dispatch [:countries %])
        :error-handler   (fn [{:keys [status status-text]}]
                           (reset! fetch-error true)
                           (js/console.log status status-text))}))

(defn ranking []
  (let [fetch-error? (r/atom false)]
    (fetch-countries! fetch-error?)
    (fn []
      [:<>
       (if @fetch-error?
         [:p "Ranking is not available, please check the connection."]
         (if (empty? @(rf/subscribe [:countries]))
           [:p "No data yet..."]
           [ranking-table]))])))

(defn initialize [order]
  {:order order
   :countries []})
