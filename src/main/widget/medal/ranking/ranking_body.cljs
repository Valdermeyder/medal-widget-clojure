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
             :or   {gold 0 silver 0 bronze 0}
             :as   country}]
         (merge {:total (+ gold silver bronze)} country))
       countries))

(defn calc-flag-positions [countries]
  (reduce-kv (fn [positions index {:keys [code]}]
            (merge positions {code (str "0 " (* index -17) "px")})) {} (vec (sort-by :code countries))))

(defn ranking-body []
  (let [flag-positions (calc-flag-positions @countries)]
    [:<>
     (map-indexed
       (fn [index country]
         (let [country-code (:code country)]
         [ranking-row (merge {:key           country-code
                              :ranking       (inc index)
                              :flag-position (get flag-positions country-code)} country)]))
       (slice-countries (sort-by-medals (add-total @countries) @order)))]))
