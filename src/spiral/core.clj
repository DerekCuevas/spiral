(ns spiral.core
  (:gen-class))

(defn directions [clockwise]
  (if clockwise [:up :right :down :left] [:up :left :down :right]))

(defn move [[x y] direction]
  (case direction
    :up [x (inc y)]
    :right [(inc x) y]
    :down [x (dec y)]
    :left [(dec x) y]))

(defn direction [directions idx]
  (directions (mod idx (count directions))))

(defn side [directions idx length]
  (repeat length (direction directions idx)))

(defn spiral
  ([]
    (spiral true))
  ([clockwise]
    (->> (interleave (range) (range))
         (map inc)
         (map-indexed (partial side (directions clockwise)))
         (flatten)
         (reductions move [0 0])))
  ([clockwise n]
    (take n (spiral clockwise))))
