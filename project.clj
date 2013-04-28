(defproject cljs-stl "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.logic "0.8.3"]
                 [org.clojure/tools.macro "0.1.2"]
                 [org.clojure/data.json "0.2.2"]]
  :source-paths ["clojurescript/src/clj"
                 "clojurescript/src/cljs"]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :cljsbuild {:builds
               [{:source-paths ["src/cljs_stl/browser"],
                 :id "browser",
                 :compiler {:output-to "browser.js",
                            :optimizations :simple}}
                {:source-paths ["src/cljs_stl/spectral"],
                 :id "spectral",
                 :compiler {:output-to "spectral_norm.js",
                            :optimizations :advanced}}
                 {:source-paths ["src/cljs_stl/spectral"],
                 :id "spectral_pp",
                 :compiler {:output-to "spectral_norm_pp.js",
                            :optimizations :advanced}}
                {:source-paths ["src/cljs_stl/zebra"],
                 :id "zebra",
                 :compiler {:output-to "zebra.js",
                            :pretty-print true
                            :optimizations :advanced}}]})
