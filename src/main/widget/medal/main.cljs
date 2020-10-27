(ns widget.medal.main
  (:require [reagent.dom :as rd]
            [widget.medal.app :refer [app]]))

(defn ^:export init
  [id order]
  (rd/render
    [app {:order order}]
    (.getElementById js/document id)))
