(ns Data.Ord.Unsafe._foreign)

(defn- number-compare [lt gt eq x y]
  (if (or (Double/isNaN x) (Double/isNaN y))
    gt
    (cond
      (< x y) lt
      (= x y) eq
      :else gt)))

(defn unsafeCompareImpl [lt]
  (fn [eq]
    (fn [gt]
      (fn [x]
        (fn [y]
          (if (instance? Double x)
            (number-compare lt gt eq x y)
            (let [res (compare x y)]
              (cond
                (< res 0) lt
                (> res 0) gt
                :else eq))))))))
