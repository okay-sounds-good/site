(ns osg.build
  (:gen-class)
  (:require optimus.export
            [optimus.optimizations :as optimizations]
            [osg.dev :as dev]
            [osg.site :as site]
            [stasis.core :as stasis]))

(defn export! []
  (println "Building...")
  (let [assets     (do (println " • optimize assets")
                       (optimizations/all (dev/get-public-assets) {}))
        pages      (do (println " • collect pages")
                       (site/get-pages))
        target-dir "target/"]
    (println " • empty out" target-dir)
    (stasis/empty-directory! target-dir)
    (println " • save optimized assets to" target-dir)
    (optimus.export/save-assets assets target-dir)
    (println " • export pages to" target-dir)
    (stasis/export-pages pages target-dir {:optimus-assets assets})
    (println "DONE")
    (shutdown-agents)))

(defn -main [& _args]
  (try
    (export!)
    (System/exit 0)
    (catch Exception e
      (System/exit 1))))
