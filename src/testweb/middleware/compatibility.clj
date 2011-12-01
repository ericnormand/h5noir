(ns testweb.middleware.compatibility
  (:use ring.util.response))

(defn uav-middleware [hndlr]
  (fn [req]
    (header (hndlr req) "X-UA-Compatible" "IE=edge,chrome=1")))
