(ns spiral.core
  (:gen-class))

(def directions [:up :right :down :left])

(defn move [[x y] direction]
  (case direction
    :up [x (inc y)]
    :right [(inc x) y]
    :down [x (dec y)]
    :left [(dec x) y]))

(defn direction [idx]
  (get directions (mod idx (count directions))))

(defn side [idx length]
  (repeat (inc length) (direction idx)))

(defn spiral [n]
  (->> (interleave (range) (range))
       (map-indexed side)
       (apply concat)
       (take n)
       (reductions move [0 0])))
