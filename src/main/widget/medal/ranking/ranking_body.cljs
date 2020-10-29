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

(defn slice-countries
  ([countries] (slice-countries countries 10))
  ([countries show-number]
   (if (< show-number (count countries)) (subvec countries 0 show-number) countries)))

(defn ranking-body []
  (let [countries (atom [])]
    (fetch-countries! countries)
    (fn []
      [:<>
       (map-indexed (fn [index country]
              [ranking-row (merge {:key (:code country), :ranking (inc index)} country)])
            (slice-countries @countries))])))
