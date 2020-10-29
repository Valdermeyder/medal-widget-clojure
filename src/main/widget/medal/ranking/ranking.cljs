(ns widget.medal.ranking.ranking
  (:require [reagent.core :as r]
            [ajax.core :refer [GET]]
            [widget.medal.countries :refer [countries]]
            [widget.medal.ranking.table :refer [ranking-table]]))

(defn fetch-countries! [countries fetch-error]
  (reset! fetch-error false)
  (GET "/json/ranking.json"
       {:response-format :json
        :keywords?       true
        :handler         #(reset! countries %)
        :error-handler   (fn [{:keys [status status-text]}]
                           (reset! fetch-error true)
                           (js/console.log status status-text))}))

(defn ranking []
  (let [fetch-error? (r/atom false)]
    (fetch-countries! countries fetch-error?)
    (fn []
      [:<>
       (if @fetch-error?
         [:p "Ranking is not available, please check the connection."]
         (if (empty? @countries)
           [:p "No data yet..."]
           [ranking-table]))])))
