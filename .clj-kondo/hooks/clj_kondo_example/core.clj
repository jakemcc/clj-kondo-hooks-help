(ns hooks.clj-kondo-example.core)

(defmacro subscribe
  [topic f & additional-args]
  (let [x `(fn [msg#]
             (~f ~@additional-args msg#))]
    (prn :f-meta (meta f))
    (prn x)
    x))


;; another attempt at a different style simplified macro
#_
(defmacro subscribe
  [topic f & additional-args]
  `(let [msg# {}]
     (~f ~@additional-args msg#)))
