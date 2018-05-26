(ns Data.Eq._foreign)

(defn refEq [r1]
  (fn [r2]
    (= r1 r2)))

(def eqArrayImpl refEq)