(ns rr.core
  (:refer-clojure :exclude [line-seq])
  (:import [java.io File]
           [org.apache.commons.io.input ReversedLinesFileReader])
  (:require [clojure.java.io :as io]))

(defprotocol MakeReader
  (make-reader [x] "Create a ReversedLinesFileReader."))

(defn ^ReversedLinesFileReader reader
  [x]
  (make-reader x))

(extend-type File
  MakeReader
  (make-reader [x] (ReversedLinesFileReader. x)))

(extend-type String
  MakeReader
  (make-reader [x] (ReversedLinesFileReader. (io/file x))))

(defn line-seq [r]
  (cons (.readLine r) (lazy-seq (line-seq r))))
