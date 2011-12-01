(ns testweb.server
  (:require [noir.server :as server]))

(server/load-views "src/testweb/views/")
(server/load-views "src/testweb/middleware/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'testweb})))

