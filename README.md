# lein-extend-cp

lein-extend-cp is a plugin to add paths to your classpath.

## Usage

Don't. In all but the most uncommon scenarios, by adding dependencies to the classpath this way, you'll be shooting yourself in the foot. Rather, you should
add dependencies in the conventional way. For more on this see [repeatability](https://github.com/technomancy/leiningen/wiki/Repeatability).

If, however, you do feel you need to use this plugin, use it thusly:

Put `[lein-extend-cp "0.1.0"]` into the `:plugins` vector of your project.clj.

Then, to actually specify the paths you want added to the classpath, put them in the `:lein-extend-cp` map of your project.clj:

    :lein-extend-cp {:paths ["foo.jar" "bar.jar"] :scripts ["script1.clj" "script2.clj"]}

The items in `:paths` will be added to the classpath. `:scripts` are paths to files which will be `load-file`'d and which
should return a collection of paths to be added to the classpath. For example, the contents of "script1.clj" might look something like:

    (->> "some-lib-dir" (clojure.java.io/file) (file-seq) (map #(.toString %)) (filter #(.endsWith % ".jar")))

This would add all the jar files in the some-lib-dir directory to your classpath.

## License

Copyright © 2013 Nick Gieschen

Distributed under the Eclipse Public License, the same as Clojure.
