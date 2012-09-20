(defproject cljs-stl "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :extra-classpath-dirs ["checkouts/clojurescript/src/clj"
                         "checkouts/clojurescript/src/cljs"]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [core.logic "0.8.0-alpha4-SNAPSHOT"]]
  :dev-dependencies [[lein-swank "1.4.4"]
                     [lein-cljsbuild "0.2.7"]]
  :cljsbuild {:builds {:browser {:source-path "src/cljs_stl/browser"
                                 :compiler {:output-to "browser.js"
                                            :optimizations :simple}}
                       :zebra {:source-path "src/cljs_stl/zebra"
                               :compiler {:output-to "zebra.js"
                                          :optimizations :advanced}}
                       :spectral {:source-path "src/cljs_stl/spectral"
                                  :compiler {:output-to "spectral_norm.js"
                                             :optimizations :advanced}}}})
