(ns Data.Show._foreign
  (:require [clojure.string :as s]))

(def showIntImpl str)

(def showNumberImpl str)

(def showCharImpl str)

(def showStringImpl str)

(defn showArrayImpl [f]
  (fn [arr]
    (str "["
         (s/join ", " (map f arr))
         "]")))

(defn _cons [head]
  (fn [tail]
    (into [] (concat head tail))))

(defn join [sep]
  (fn [xs]
    (s/join sep xs)))
