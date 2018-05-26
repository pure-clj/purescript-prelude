(ns Data.HeytingAlgebra._foreign)

(defn boolConj [b1]
  (fn [b2]
    (and b1 b2)))

(defn boolDisj [b1]
  (fn [b2]
    (or b1 b2)))

(defn boolNot [b]
  (not b))