(ns widget.medal.main
  (:require [reagent.dom :as rd]))

(defn ^:export init
  [id order]
  (rd/render
    [:h2 "MEDAL COUNT"]
    (.getElementById js/document id)))
