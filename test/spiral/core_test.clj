(ns spiral.core-test
  (:require [clojure.test :refer :all]
            [spiral.core :refer :all]))

(deftest spiral-test
  (testing "spiral"
    (is (= (spiral 0) '([0 0])))
    (is (= (spiral 1) '([0 0] [0 1])))
    (is (= (spiral 2) '([0 0] [0 1] [1 1])))
    (is (= (spiral 10) '([0 0] [0 1] [1 1] [1 0] [1 -1] [0 -1] [-1 -1] [-1 0] [-1 1] [-1 2] [0 2])))))
