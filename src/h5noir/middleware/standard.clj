(ns h5noir.middleware.standard
  (:use h5noir.middleware.compatibility)
  (:use noir.server))

(add-middleware uav-middleware)
