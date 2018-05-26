(ns Test.Main._foreign)

(defn throwErr [^String msg]
  (fn []
    (throw (RuntimeException. msg))))

(defn testNumberShow [showNumber]
  (fn []
    (letfn [(testAll [cases]
              (doseq [c cases]
                (let [expc (second c)
                      actual (str (first c))]
                  (if (not= expc actual)
                    (throw (RuntimeException. (str "For " (first c)
                                                   ", expected " expc
                                                   ", got: " actual ".")))))))]
      (testAll
       ;; Within Int range
       [0.0 "0.0"]
       [1.0 "1.0"]
       [-1.0 "-1.0"]
       [500.0 "500.0"]
       ;; Outside Int range
       [1e10 "10000000000.0"]
       [(+ 1e10 0.5) "10000000000.5"]
       [-1e10 "-10000000000.0"]
       [(- -1e10 0.5) "-10000000000.5"]
       ;; With exponent
       [1e21 "1E+21"]
       [1e-21 "1E-21"]
       ;; With decimal and exponent
       [1.5e21 "1.5E21"]
       [1.5e-10 "1.5E-10"]

       [Double/NaN "NaN"]
       [Double/POSITIVE_INFINITY "Infinity"]
       [Double/NEGATIVE_INFINITY "-Infinity"]))))