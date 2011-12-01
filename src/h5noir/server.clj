(ns h5noir.server
  (:require [noir.server :as server])
  (:use [h5noir.middleware.standard]))

(server/load-views "src/h5noir/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'h5noir})))

