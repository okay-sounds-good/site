(ns osg.site
  (:gen-class)
  (:require [hiccup.core :as hiccup]
            [osg.util :refer [layout]]))

(def body
  (->
   [:div.section
    [:div.container
     [:h1 "Okay sounds good!"]
     [:p "AHHHHH this is so siiick"]]]
   (layout "OSG" "foooooobar")))


(defn get-pages []
  (merge {"/index.html" (hiccup/html body)}))

