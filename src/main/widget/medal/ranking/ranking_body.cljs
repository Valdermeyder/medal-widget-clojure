(ns widget.medal.ranking.ranking-body
  (:require [widget.medal.ranking.ranking-row :refer [ranking-row]]
            [widget.medal.countries :refer [countries]]))

(defn slice-countries
  ([countries] (slice-countries countries 10))
  ([countries show-number]
   (if (< show-number (count countries)) (subvec countries 0 show-number) countries)))

(defn ranking-body []
  [:<>
   (map-indexed (fn [index country]
                  [ranking-row (merge {:key (:code country), :ranking (inc index)} country)])
                (slice-countries @countries))])
