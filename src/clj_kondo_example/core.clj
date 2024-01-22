(ns clj-kondo-example.core)

#_{:clj-kondo/ignore [:unused-binding]}
(defn remote-sub [topic f]
  ;; not important for this example, subscribes to messages on a topic
  ;; and passes to f
  )

(defmacro subscribe
  [topic f & additional-args]
  `(remote-sub ~topic
               (fn [msg#]
                 (~f ~@additional-args msg#))))

(defn do-work
  [x msg]
  (prn x msg))

(subscribe "a-topic" do-work) ;; should warn about arguments
(subscribe "a-topic" do-work 1)

;; warns about arguments and lsp-find-references works
(fn [msg]
  (do-work msg))
