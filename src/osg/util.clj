(ns osg.util)

(defn header
  [& [title description]]
  [:head
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
   [:title (or title "OKAY")]
   [:meta {:charset "utf-8"}]
   [:meta {:name "Description" :content (or description "Your favorite text-only Podcast.")}]
   [:link {:href "https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css" :rel "stylesheet"}]
   [:link {:href "/css/site.css" :type "text/css" :rel "stylesheet"}]])

(defn layout
  [body & [title description]]
  [:html
   (header title description)
   body])
