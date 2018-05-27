(ns Data.EuclideanRing._foreign)

(defn intDegree [x]
  (min (Math/abs x) Integer/MAX_VALUE))

(defn intDiv [x]
  (fn [y]
    (if (zero? y)
      0
      (quot x y))))

(defn intMod [x]
  (fn [y]
    (if (zero? y)
      0
      (mod x y))))

(defn numDiv [n1]
  (fn [n2]
    (/ n1 n2)))