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
                            :optimizations :advanced
                            :pretty-print false}}
                {:source-paths ["src/cljs_stl/spectral"],
                 :id "spectral_pp",
                 :compiler {:output-to "spectral_norm_pp.js",
                            :optimizations :advanced}}
                {:source-paths ["src/cljs_stl/spectral"],
                 :id "spectral_none",
                 :compiler {:output-to "spectral_norm_none.js",
                            :optimizations :none
                            :pretty-print false}}
                {:source-paths ["src/cljs_stl/spectral"],
                 :id "spectral_ws",
                 :compiler {:output-to "spectral_norm_ws.js",
                            :optimizations :whitespace
                            :pretty-print false}}
                {:source-paths ["src/cljs_stl/hello_world"],
                 :id "hello",
                 :compiler {:output-to "hello_world.js",
                            :pretty-print false
                            :optimizations :advanced}}
                {:source-paths ["src/cljs_stl/hello_world"],
                 :id "hello_pp",
                 :compiler {:output-to "hello_world_pp.js",
                            :optimizations :advanced}}
                {:source-paths ["src/cljs_stl/hello_world"],
                 :id "hello_none",
                 :compiler {:output-to "hello_world_none.js",
                            :optimizations :none
                            :pretty-print false}}
                {:source-paths ["src/cljs_stl/zebra"],

                 :id "zebra",
                 :compiler {:output-to "zebra.js",
                            :pretty-print false
                            :optimizations :advanced}}]})
