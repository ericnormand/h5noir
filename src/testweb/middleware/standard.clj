(ns testweb.middleware.standard
  (:use testweb.middleware.compatibility)
  (:use noir.server))

(add-middleware uav-middleware)
