(ns Data.Functor._foreign)

(defn arrayMap [f]
  (fn [arr]
    (map f arr)))