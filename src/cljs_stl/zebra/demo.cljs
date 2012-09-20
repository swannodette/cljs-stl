(ns cljs-stl.zebra.demo
  (:require-macros [cljs.core.logic.macros :as m]
                   [clojure.tools.macro :as mu])
  (:use [cljs.core.logic :only
         [firsto membero lvar *occurs-check*]]))

(defn js-print [& args]
  (if (js* "typeof console != 'undefined'")
    (.log js/console (apply str args))
    (js/print (apply str args))))

(set! *print-fn* js-print)

(m/defne righto [x y l]
  ([_ _ [x y . r]])
  ([_ _ [_ . r]] (righto x y r)))

(defn nexto [x y l]
  (m/conde
    [(righto x y l)]
    [(righto y x l)]))

(defn zebrao [hs]
  (mu/symbol-macrolet [_ (lvar)]
   (m/all
    (m/== [_ _ [_ _ 'milk _ _] _ _] hs)
    (firsto hs ['norwegian _ _ _ _])
    (nexto ['norwegian _ _ _ _] [_ _ _ _ 'blue] hs)
    (righto [_ _ _ _ 'ivory] [_ _ _ _ 'green] hs)
    (membero ['englishman _ _ _ 'red] hs)
    (membero [_ 'kools _ _ 'yellow] hs)
    (membero ['spaniard _ _ 'dog _] hs)
    (membero [_ _ 'coffee _ 'green] hs)
    (membero ['ukrainian _ 'tea _ _] hs)
    (membero [_ 'lucky-strikes 'oj _ _] hs)
    (membero ['japanese 'parliaments _ _ _] hs)
    (membero [_ 'oldgolds _ 'snails _] hs)
    (nexto [_ _ _ 'horse _] [_ 'kools _ _ _] hs)
    (nexto [_ _ _ 'fox _] [_ 'chesterfields _ _ _] hs))))

(defn ^:export run-zebra []
  (binding [*occurs-check* false]
    (m/run 1 [q] (zebrao q))))

(dotimes [_ 10]
  (time (run-zebra)))

(println (run-zebra))