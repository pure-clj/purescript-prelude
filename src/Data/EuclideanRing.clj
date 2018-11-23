(ns Data.EuclideanRing._foreign)

(defn intDegree [^long x]
  (min (Math/abs x) Integer/MAX_VALUE))

(defn intDiv [^long x]
  (fn [^long y]
    (if (zero? y)
      0
      (if (> y 0)
        (long (Math/floor (/ x y)))
        (long (- (Math/floor (/ x (- y)))))))))

(defn intMod [^long x]
  (fn [^long y]
    (if (zero? y)
      0
      (let [yy (Math/abs y)]
        (-> (mod x yy)
            (+ yy)
            (mod yy))))))

(defn numDiv [^double n1]
  (fn [^double n2]
    (/ n1 n2)))
