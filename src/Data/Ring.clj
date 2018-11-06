(ns Data.Ring._foreign)

(defn intSub [^long x]
  (fn [^long y]
    (unchecked-subtract x y)))

(defn numSub [^double x]
  (fn [^double y]
    (unchecked-subtract x y)))