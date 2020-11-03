(ns widget.medal.main
  (:require [reagent.dom :as rd]
            [re-frame.core :as rf]
            [widget.medal.widget :refer [widget]]
            [widget.medal.ranking.ranking :as ranking]))

(rf/reg-event-db
  :initialize
  (fn [_ [_ order]]
    (ranking/initialize order)))

(defn render-widget [id]
  (rd/render [widget]
             (.getElementById js/document id)))

(defn ^:export init
  ([id] (init id (name @(rf/subscribe [:order]))))
  ([id order]
   (rf/dispatch-sync [:initialize (keyword order)])
   (render-widget id)))
