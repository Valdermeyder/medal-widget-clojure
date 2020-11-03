(ns widget.medal.ranking.countries
  (:require [re-frame.core :as rf]))

(rf/reg-event-db
  :countries
  (fn [db [_ countries]]
    (assoc db :countries countries)))

(rf/reg-sub
  :countries
  (fn [db _]
    (:countries db)))
