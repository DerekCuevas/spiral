(ns spiral.core-test
  (:require [clojure.test :refer :all]
            [spiral.core :refer :all]))

(deftest spiral-test
  (testing "spiral"
    (is (= (spiral true 1) '([0 0])))
    (is (= (spiral true 2) '([0 0] [0 1])))
    (is (= (spiral true 3) '([0 0] [0 1] [1 1])))
    (is (= (spiral true 11) '([0 0] [0 1] [1 1] [1 0] [1 -1] [0 -1] [-1 -1] [-1 0] [-1 1] [-1 2] [0 2])))

    (is (= (take 3 (spiral)) '([0 0] [0 1] [1 1])))
    (is (= (take 11 (spiral)) '([0 0] [0 1] [1 1] [1 0] [1 -1] [0 -1] [-1 -1] [-1 0] [-1 1] [-1 2] [0 2])))

    (is (= (take 3 (spiral false)) '([0 0] [0 1] [-1 1])))
    (is (= (take 11 (spiral false)) '([0 0] [0 1] [-1 1] [-1 0] [-1 -1] [0 -1] [1 -1] [1 0] [1 1] [1 2] [0 2])))

    (is (= (spiral false 1) '([0 0])))
    (is (= (spiral false 2) '([0 0] [0 1])))
    (is (= (spiral false 3) '([0 0] [0 1] [-1 1])))
    (is (= (spiral false 11) '([0 0] [0 1] [-1 1] [-1 0] [-1 -1] [0 -1] [1 -1] [1 0] [1 1] [1 2] [0 2])))))
    
