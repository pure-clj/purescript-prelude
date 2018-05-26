; "use strict";

; exports.intSub = function (x) {
;   return function (y) {
;     /* jshint bitwise: false */
;     return x - y | 0;
;   };
; };

; exports.numSub = function (n1) {
;   return function (n2) {
;     return n1 - n2;
;   };
; };
(ns Data.Ring._foreign)

(defn intSub [^long x]
  (fn [^long y]
    (unchecked-subtract x y)))

(defn numSub [^double x]
  (fn [^double y]
    (unchecked-subtract x y)))