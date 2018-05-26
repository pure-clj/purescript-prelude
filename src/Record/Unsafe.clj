(ns Record.Unsafe._foreign)

(defn unsafeHas [label]
  (fn [rec]
    (->> (keys rec)
         (some #{label})
         (boolean))))

(defn unsafeGet [label]
  (fn [rec]
    (get rec label)))

(defn unsafeSet [label]
  (fn [value]
    (fn [rec]
      (assoc rec label value))))

(defn unsafeDelete [label]
  (fn [rec]
    (dissoc rec label)))