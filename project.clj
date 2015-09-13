(defproject ayato_p/rr "0.1.0-SNAPSHOT"
  :description "ReverseReader for HUGE files.e"
  :url "https://github.com/ayato-p/rr"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [commons-io/commons-io "2.4"]]
  :profiles {:dev
             {:dependencies [[criterium "0.4.3"]]
              :source-paths ["bench"]}})
