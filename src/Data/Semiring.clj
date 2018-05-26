(ns Data.Semiring._foreign)

(defn intAdd [^long x]
  (fn [^long y]
    (unchecked-add x y)))

(defn intMul [^long x]
  (fn [^long y]
    (unchecked-multiply x y)))

(defn numAdd [^double x]
  (fn [^double y]
    (unchecked-add x y)))

(defn numMul [^double x]
  (fn [^double y]
    (unchecked-multiply x y)))
