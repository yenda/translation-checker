(ns translation-checker.core
  (:require [clojure.data :as data])
  (:gen-class))

(defn get-keyset [file]
  (into #{} (-> (str "[" (slurp file) "]")
                read-string
                second
                (nth 2)
                keys)))

(defn compare-to-en [filename]
  (data/diff (get-keyset filename)
             (get-keyset "https://raw.githubusercontent.com/status-im/status-react/develop/src/status_im/translations/en.cljs")))

(defn -main
  [filename & args]
  (let [[to-remove missing _] (compare-to-en filename)]
    (when to-remove
      (println "Remove: " to-remove))
    (when missing
      (println "Missing: " missing))
    (when-not (and to-remove missing)
      (println "Translation looks OK"))))
