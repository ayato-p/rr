(ns bench
  (:require [clojure.java.io :as io]
            [criterium.core :as c]
            [rr.core :as rr]))

(def huge-file "./dev-resources/huge.txt")

(defn last-line-via-stdio []
  (with-open [r (io/reader huge-file)]
    (last (line-seq r))))

(defn last-line-via-rr []
  (with-open [r (rr/reader huge-file)]
    (first (rr/line-seq r))))

(c/bench (last-line-via-stdio))
;; Evaluation count : 300 in 60 samples of 5 calls.
;;              Execution time mean : 209.071375 ms
;;     Execution time std-deviation : 2.580759 ms
;;    Execution time lower quantile : 205.964662 ms ( 2.5%)
;;    Execution time upper quantile : 214.501153 ms (97.5%)
;;                    Overhead used : 9.982297 ns

;; Found 2 outliers in 60 samples (3.3333 %)
;;      low-severe   2 (3.3333 %)
;;  Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

(c/bench (last-line-via-rr))
;; Evaluation count : 7811880 in 60 samples of 130198 calls.
;;              Execution time mean : 7.842190 µs
;;     Execution time std-deviation : 68.214523 ns
;;    Execution time lower quantile : 7.743285 µs ( 2.5%)
;;    Execution time upper quantile : 8.001377 µs (97.5%)
;;                    Overhead used : 9.982297 ns

;; Found 2 outliers in 60 samples (3.3333 %)
;;      low-severe   2 (3.3333 %)
;;  Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
