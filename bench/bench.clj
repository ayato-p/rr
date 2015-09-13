(ns bench
  (:require [clojure.java.io :as io]
            [criterium.core :as c]
            [rr.core :as rr]))

(def huge-file "./dev-resources/huge.txt")

(defn last-line-via-stdio []
  (with-open [r (io/reader huge-file)]
    (first (line-seq r))))

(defn last-line-via-rr []
  (with-open [r (rr/reader huge-file)]
    (first (rr/line-seq r))))

(c/bench (last-line-via-stdio))
;; Evaluation count : 240 in 60 samples of 4 calls.
;;              Execution time mean : 282.857924 ms
;;     Execution time std-deviation : 1.644174 ms
;;    Execution time lower quantile : 281.961398 ms ( 2.5%)
;;    Execution time upper quantile : 283.869007 ms (97.5%)
;;                    Overhead used : 11.058201 ns

;; Found 4 outliers in 60 samples (6.6667 %)
;;      low-severe   3 (5.0000 %)
;;      low-mild     1 (1.6667 %)
;;  Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

(c/bench (last-line-via-rr))
;; Evaluation count : 3837720 in 60 samples of 63962 calls.
;;              Execution time mean : 15.669411 µs
;;     Execution time std-deviation : 48.390913 ns
;;    Execution time lower quantile : 15.632208 µs ( 2.5%)
;;    Execution time upper quantile : 15.729416 µs (97.5%)
;;                    Overhead used : 11.058201 ns

;; Found 4 outliers in 60 samples (6.6667 %)
;;      low-severe   3 (5.0000 %)
;;      low-mild     1 (1.6667 %)
;;  Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
