(ns osg.site
  (:gen-class)
  (:require [clojure.string :as str]
            [hiccup.core :as hiccup]
            [osg.mock :refer [covers titles txt]]
            [osg.util :as util]))

#_(def tiled-posts
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

(def top-hero
  [:section {:class "hero is-small is-link has-background-grey-lighter has-text-grey-darker"}
   [:div {:class "hero-body"}
    [:div {:class "container has-text-centered pt-5 pb-5"}
     [:p.title {:class "has-text-grey-darker is-italic"} "Okay Sounds Good"]
     #_ [:p.subtitle "Subtitle"]
     [:div {:class "pt-3"}
      [:nav
       [:a {:class "link is-info mr-5"}
        "BLOG"]
       [:a {:class "link is-info"}
        "ABOUT"]]]]]])

(def footer
  [:footer {:class "footer has-background-grey-lighter"}])

(defn render-article
  [idx]
  [:div {:class "tile is-parent p-2 mb-6"}
   [:div {:class "tile is-child is-4"}
    [:figure {:class "image is-3by2"}
     [:img {:class "cropped"
            :src (nth covers idx)}]]]
   [:div {:class "tile is-parent is-vertical is-8 ml-2"}
    [:div {:class "tile is-child is-uppercase"}
     [:p {:class "title is-size-5 has-text-grey-dark"} (nth titles idx)]
     [:p {:class "subtitle is-size-6 has-text-grey"} "BY: Prosciutto"]]
    [:div {:class "tile is-child"}
     [:p {:class "has-text-grey"}
      (str (str/join (take (+ 150 (rand-int 30)) txt))  "...")]]]])

(def articles
  [:section {:class "container is-fluid"}
   [:div {:class "tile is-ancestor"}
    [:div {:class "tile is-2"}]
    (into [:div {:class "tile is-vertical is-8 mt-6"}]
          (mapv render-article (range 3)))
    [:div {:class "tile is-2"}]]])


(defn get-pages []
  {"/index.html"
   (hiccup/html
    [:html
     (util/header)
     top-hero
     articles
     footer])})
