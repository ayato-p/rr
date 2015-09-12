(ns rr.core-test
  (:refer-clojure :exclude [line-seq])
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [rr.core :refer :all])
  (:import [java.io File]
           [org.apache.commons.io.input ReversedLinesFileReader]))

(def f "dev-resources/test.txt")

(deftest reader-test
  (with-open [r (reader (io/file f))]
    (is (instance? ReversedLinesFileReader r)))
  (with-open [r (reader f)]
    (is (instance? ReversedLinesFileReader r))))

(deftest line-seq-test
  (let [s (line-seq (reader f))]
    (is (instance? clojure.lang.Cons s))
    (is (instance? clojure.lang.LazySeq (rest s)))
    (is (= "Good bye!" (first s)))
    (is (= "Hello, world" (second s)))))
