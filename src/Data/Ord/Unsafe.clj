(ns Data.Ord.Unsafe._foreign)

(defn unsafeCompareImpl [lt]
  (fn [eq]
    (fn [gt]
      (fn [x]
        (fn [y]
          (if (< x y)
            lt
            (if (= x y)
              eq
              gt)))))))