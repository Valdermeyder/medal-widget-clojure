(ns widget.medal.ranking.ranking-body
  (:require [widget.medal.ranking.ranking-row :refer [ranking-row]]
            [widget.medal.countries :refer [countries order]]))

(defn slice-countries
  ([countries] (slice-countries countries 10))
  ([countries show-number]
   (if (< show-number (count countries)) (subvec (vec countries) 0 show-number) countries)))

(defn sort-by-medals [countries main-order]
  (sort-by (juxt main-order :gold :silver :bronze) #(compare %2 %1) countries))

(defn add-total [countries]
  (map (fn [{:keys [gold silver bronze]
             :or {gold 0 silver 0 bronze 0}
             :as country}]
         (merge {:total (+ gold silver bronze)} country))
       countries))

(defn ranking-body []
  [:<>
   (map-indexed (fn [index country]
                  [ranking-row (merge {:key (:code country), :ranking (inc index)} country)])
                (slice-countries (sort-by-medals (add-total @countries) @order)))])
