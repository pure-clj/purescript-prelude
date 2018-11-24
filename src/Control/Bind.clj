(ns Control.Bind._foreign)

(defn arrayBind [arr]
  (fn [f]
    (vec (mapcat f arr))))
