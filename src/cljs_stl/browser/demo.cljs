(ns cljs-stl.browser.demo
  (:require [clojure.string :as s]
            [cljs.reader :as r]
            [clojure.browser.repl :as repl]))

(repl/connect "http://localhost:9000/repl")

;; =============================================================================
;; Warnings!

(comment

  ;; undeclared var
  (defn foo []
    (let [x z]))

  ;; wrong # of args
  (defn foo []
    (let [f (fn [a b]
              (+ a b))]
      (f 1)))

  )

;; =============================================================================
;; BAT REPL

(comment

  (def box (.getElementById js/document "box"))

  (set! (.. box -style -backgroundColor) "blue")
  (set! (.. box -style -backgroundColor) "red")

  (set! (.. box -backgroundImage "clojure.png"))
  (set! (.. box -className "spin"))

  )