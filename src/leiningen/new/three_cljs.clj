(ns leiningen.new.three-cljs
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "three-cljs"))

(defn three-cljs
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info (str "Generating fresh 'lein new' three-cljs project."
                    "Change into your '" name "' directory and run 'lein figwheel'\n"
                    "Wait for it to finish compiling\n"
                    "Then open 'http://localhost:3449/index.html' in your browser"))
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["resources/public/index.html" (render "index.html" data)]
             [".gitignore" (render "gitignore" data)]
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)])))
