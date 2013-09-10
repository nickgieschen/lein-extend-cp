(ns leiningen.extend-cp)

(defn extend-cp
"Adds paths to the classpath

The paths to be added to the classpath are specified in the
:lein-extend-cp map of your project.clj. The map can contain two
possible items, :paths and :scripts. :paths is a coll of paths to
be added to the the classpath and :scripts is a coll of paths to scripts
which will be read-file'd and which should return a coll of paths to be
added to the classpath. E.g:

  :lein-extend-cp {:paths [\"a.jar\" \"some-path/b.jar\"]
                   :scripts [\"script1.clj\" \"script2.clj\"]}"
  [project & keys])
