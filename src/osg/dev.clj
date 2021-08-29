(ns osg.dev
  (:gen-class)
  (:require [optimus.assets :as assets]
            [optimus.optimizations :as optimizations]
            [optimus.prime :as optimus]
            [optimus.strategies :refer [serve-live-assets]]
            [osg.site :as site]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.middleware.refresh :refer [wrap-refresh]]
            [stasis.core :as stasis]))

(defn get-public-assets []
  (assets/load-bundle "public" "styles.css" ["/css/site.css"]))

(def serve!
  "Serves the rendered HTML locally for development with hot reloading."
  (-> (stasis/serve-pages site/get-pages)
      (optimus/wrap get-public-assets optimizations/none serve-live-assets)
      wrap-content-type
      wrap-refresh))
