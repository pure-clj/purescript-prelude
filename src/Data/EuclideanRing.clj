(ns Data.EuclideanRing._foreign)

(defn intDegree [x]
  (min (Math/abs x) Integer/MAX_VALUE))

(defn intDiv [x]
  (fn [y]
    (if (zero? y)
      0
      (if (pos? y)
        (Math/floor (/ x y))
        (- (Math/floor (/ x (- y))))))))

(defn intMod [x]
  (fn [y]
    (if (zero? y)
      0
      (let [yy (Math/abs y)]
        (mod (+ (mod x yy) yy) yy)))))

(defn numDiv [n1]
  (fn [n2]
    (/ n1 n2)))