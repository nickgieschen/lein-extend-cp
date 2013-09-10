(ns lein-extend-cp.plugin
  (:require [robert.hooke]
            [leiningen.core.classpath]
            [clojure.string :refer [blank?]]
            [leiningen.core.main :refer [debug]]))

(defn add-more-cps [f & args]
  (let [opts (:lein-extend-cp (first args))
        paths (filter #(not (blank? %)) (concat (:paths opts)
                                 (mapcat load-file (:scripts opts))))]
        (debug (str "lein-extend-cp extending classpath with: \n" (reduce #(str %1 %2 "\n") "" paths)))
    (for [path (concat (apply f args)
                       paths)
          :when path]
      path)))

(defn hooks []
  (robert.hooke/add-hook #'leiningen.core.classpath/get-classpath
                         #'add-more-cps))
