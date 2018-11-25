(ns Data.Functor._foreign)

(defn arrayMap [f]
  (fn [arr]
    (mapv f arr)))