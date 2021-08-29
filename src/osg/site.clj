(ns osg.site
  (:gen-class)
  (:require [clojure.string :as str]
            [hiccup.core :as hiccup]
            [osg.mock :refer [covers titles txt]]
            [osg.util :refer [layout]]))

(def tiled-posts
  [:div {:class "tile is-ancestor"}
   [:div {:class "tile is-12"}
    [:div {:class "tile is-parent has-background-grey-dark"}
     [:article {:class "tile is-child box"}
      [:p {:class "title"} (nth titles 0)]
      [:p {:class "subtitle"} "Aligned with the right column"]
      [:figure {:class "image is-1by1"}
       [:img {:src (nth covers 0)}]]
      [:div {:class "content"}
       [:p (str (str/join (take 200 txt))  "...")]]]]
    [:div {:class "tile"}
     [:div {:class "tile is-parent is-vertical has-background-grey-dark"}
      [:article {:class "tile is-child box"}
       [:p {:class "title"} (nth titles 1)]
       [:p {:class "subtitle"} "Top box"]
       [:figure {:class "image is-3by2"}
        [:img {:class "cropped"
               :src (nth covers 1)}]]]
      [:article {:class "tile is-child box"}
       [:p {:class "title"} (nth titles 2)]
       [:p {:class "subtitle"} "Bottom box"]
       [:figure {:class "image is-3by2"}
        [:img {:class "cropped"
               :src (nth covers 2)}]]]]]]])

(def body
  [:div.section
   [:div.container
    tiled-posts]])

(defn get-pages []
  (merge {"/index.html" (-> body layout hiccup/html)}))
