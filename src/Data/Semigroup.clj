(ns Data.Semigroup._foreign)

(defn concatString [s1]
  (fn [s2]
    (str s1 s2)))

(defn concatArray [xs]
  (fn [ys]
    (into [] (concat xs ys))))