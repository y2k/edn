(ns test
  (:require ["../src/main" :as m]))

(defn- assert [expected actual]
  (if (= expected actual)
    (println "Test result: SUCCESS")
    (throw (Error. (str "Test result: FAILED\n- Expected: " expected " [" (type expected) "]\n-   Actual: " actual " [" (type actual) "]")))))

(assert "1" (m/to_string 1))
(assert "\"1\"" (m/to_string "1"))
(assert "[]" (m/to_string []))
(assert "[1]" (m/to_string [1]))
(assert "[1 2]" (m/to_string [1 2]))
(assert "[1 [3 4] 2]" (m/to_string [1 [3 4] 2]))
(assert "{\"a\" 2}" (m/to_string {:a 2}))
(assert "{\"a\" 2 \"b\" 4}" (m/to_string {:a 2 :b 4}))
(assert "{\"a\" {\"b\" 2 \"c\" 4} \"d\" 4}" (m/to_string {:a {:b 2 :c 4} :d 4}))
(assert "{\"user\" \"pepe\"}" (m/to_string {:user :pepe}))
(assert "{}" (m/to_string {}))
(assert "(1 2)" (m/to_string (list 1 2)))
(assert "(\"1\" 2)" (m/to_string (list "1" 2)))
(assert "(a b)" (m/to_string (list (quote a) (quote b))))
(assert "(a b)" (m/to_string (list 'a 'b)))
(assert "(a b)" (m/to_string (quote (a b))))
