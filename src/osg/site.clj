(ns osg.site
  (:gen-class)
  (:require [stasis.core :as stasis]
            [osg.util :refer [layout]]
            [hiccup.core :as hiccup]))

(def body
  (->
   [:div.section
    [:div.container
     [:h1 "Okay sounds good!"]]]
   (layout "OSG" "foooooobar")))


(defn get-pages []
  (merge {"/index.html" (hiccup/html body)}))

