(ns Data.Eq._foreign)

(defn refEq [r1]
  (fn [r2]
    (= r1 r2)))

(defn numberEq [n1]
  (fn [n2]
    (if (or (Double/isNaN n1)
            (Double/isNaN n2))
        false
        (= n1 n2))))

(defn eqArrayImpl [f]
  (fn [xs]
    (fn [ys]
      (if (not= (count xs) (count ys))
        false
        ;; this is ugly but faster than using `every?`
        ;; because it short circuits as soon as it's false
        (loop [xs* xs
               ys* ys]
          (if (and (seq xs*) (seq ys*))
            (if ((f (first xs*)) (first ys*))
              (recur (next xs*) (next ys*))
              false)
            true))))))
