(ns widget.medal.main
  (:require [reagent.dom :as rd]
            [widget.medal.app :refer [app]]
            [widget.medal.countries :as countries]))

(defn ^:export init
  ([id] init id (name @countries/order))
  ([id order]
   (reset! countries/order (keyword order))
   (rd/render
     [app]
     (.getElementById js/document id))))
