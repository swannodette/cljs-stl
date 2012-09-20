(ns cljs-stl.spectral.demo)

(defn a [i j]
  (/ 1 (+ (/ (* (+ i j) (+ i j 1)) 2) i 1)))

(defn au [u v]
  (let [len (alength u)]
    (dotimes [i len]
      (loop [t 0 j 0]
        (if (< j len)
          (recur (+ t (* (a i j) (aget u j))) (inc j))
          (aset v i t))))))

(defn atu [u v]
  (let [len (alength u)]
    (dotimes [i len]
      (loop [t 0 j 0]
        (if (< j len)
          (recur (+ t (* (a j i) (aget u j))) (inc j))
          (aset v i t))))))

(defn atau [u v w]
  (au u w)
  (atu w v))

(defn approximate [n]
  (let [u (array) v (array) w (array)]
    (dotimes [i n]
      (aset u i 1) (aset v i 0) (aset w i 0))
    (dotimes [i 10]
      (atau u v w)
      (atau v u w))
    (loop [i 0 vbv 0 vv 0]
      (if (< i n)
        (recur (inc i)
               (+ vbv (* (aget u i) (aget v i)))
               (+ vv (* (aget v i) (aget v i))))
        (.sqrt js/Math (/ vbv vv))))))

(js/print (approximate 5500))
