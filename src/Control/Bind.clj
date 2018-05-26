(ns Control.Bind._foreign)

(defn arrayBind [arr]
  (fn [f]
    (mapv f arr)))