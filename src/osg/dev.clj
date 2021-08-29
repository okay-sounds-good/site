(ns osg.dev
  (:gen-class)
  (:require [hawk.core :as hawk]
            [osg.site :as site]
            [stasis.core :as stasis]
            [optimus.prime :as optimus]
            [optimus.assets :as assets]
            [optimus.optimizations :as optimizations]
            [optimus.strategies :refer [serve-live-assets]]
            [optimus.export]
            [ring.middleware.content-type :refer [wrap-content-type]]))

;; (def watcher (atom nil))

;; (defn stop-hot-reload! []
;;   (hawk/stop! @watcher))

;; (defn init-hot-reload! []
;;   (reset! watcher
;;           (hawk/watch! [{:paths ["src/" "resources/"]
;;                          :handler (fn [ctx e]
;;                                     (println "event: " e)
;;                                     (println "context: " ctx)
;;                                     ctx)}])))

;; (defn tsss! []
;;   (println "init file watchers...🔥")
;;   (init-hot-reload!)
;;   (loop []
;;     (try
;;       (Thread/sleep 500)
;;       (catch Exception e
;;         (println e)
;;         (stop-hot-reload!)))
;;     (recur)))

;; (defn -main [& _args] (tsss!))

(defn get-public-assets []
  (assets/load-bundle "public" "styles.css" ["/css/site.css"]))

(def serve!
  "Serves the rendered HTML locally for development with hot reloading."
  (-> (stasis/serve-pages site/get-pages)
      (optimus/wrap get-public-assets optimizations/none serve-live-assets)
      wrap-content-type))
