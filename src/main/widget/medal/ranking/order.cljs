(ns widget.medal.ranking.order
  (:require [re-frame.core :as rf]))

(rf/reg-event-db
  :order
  (fn [db [_ order]]
    (assoc db :order order)))

(rf/reg-sub
  :order
  (fn [db _]
    (:order db)))
