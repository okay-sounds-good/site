(ns osg.build
  (:gen-class)
  (:require optimus.export
            [optimus.optimizations :as optimizations]
            [osg.dev :as dev]
            [osg.site :as site]
            [stasis.core :as stasis]))

(defn export! []
  (let [assets     (optimizations/all (dev/get-public-assets) {})
        pages      (site/get-pages)
        target-dir "target/"]
    (stasis/empty-directory! target-dir)
    (optimus.export/save-assets assets target-dir)
    (stasis/export-pages pages target-dir {:optimus-assets assets})))

(defn -main [& _args]
  (export!))
