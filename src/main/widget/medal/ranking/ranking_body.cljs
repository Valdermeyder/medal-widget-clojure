(ns widget.medal.ranking.ranking-body
  (:require [reagent.core :refer [atom]]
            [ajax.core :refer [GET json-response-format]]
            [widget.medal.ranking.ranking-row :refer [ranking-row]]))

(defn fetch-countries! [countries]
  (GET "/json/ranking.json"
       {:response-format :json
        :keywords?       true
        :handler         #(reset! countries %)
        :error-handler   (fn [{:keys [status status-text]}]
                           (js/console.log status status-text))}))

(defn ranking-body []
  (let [countries (atom [])]
    (fetch-countries! countries)
    (fn []
      [:<>
       (map (fn [country]
              [ranking-row (merge {:key (:code country)} country)]) @countries)])))
