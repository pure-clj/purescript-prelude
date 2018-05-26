(ns Control.Apply._foreign)

(defn arrayApply [fs]
  (fn [xs]
    (vec (for [f fs
               x xs]
           (f x)))))