(ns widget.medal.hooks
  (:require widget.medal.main))

(defn ^:export reload []
  (widget.medal.main/init "medal-widget" "gold"))
