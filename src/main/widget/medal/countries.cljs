(ns widget.medal.countries
  (:require [reagent.core :as r]))

(def countries (r/atom []))

(def order (r/atom :gold) )
