(ns Data.Ord._foreign)

(defn ordArrayImpl [f]
  (fn [xs]
    (fn [ys]
      (let [xlen (count xs)
            ylen (count ys)
            res (reduce (fn [_ [x y]]
                          (let [o ((f x) y)]
                            (if (not= 0 o)
                              (reduced o)
                              :_end)))
                        :_end
                        (map vector xs ys))]
        (cond (not= :_end res) res
              (= xlen ylen) 0
              (> xlen ylen) -1
              :else 1)))))