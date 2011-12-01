(ns h5noir.views.welcome
  (:require [h5noir.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/" []
  (common/layout "Welcome to HTML5 Noir Boilerplate" nil
                 [:h1 "Welcome to HTML5 Noir Boilerplate"]
                 [:h2 "Introduction"]
                 [:p "HTML5 Noir Boilerplate gratefully borrows the delightful "
                  [:a {:href "http://html5boilerplate.com"} "HTML5 Boilerplate"]
                  " standard distribution and adapts it to use Hiccup, Ring, and "
                  " the rest of the Noir infrastructure."
                  ]
                 [:p "Use common/layout as a starting point to define your pages."]
                 [:h2 "Current Features:"]
                 [:ul
                  [:li "Solid layout foundation with meta tags"]
                  [:li "jquery included"]
                  [:li "X-UA-Compatible Header (middleware)"]
                  [:li "HTML5 compatibility for older browsers"]
                  [:li "CSS Reset"]
                  [:li "Google Analytics include "]
                  [:li "Javascript included at bottom"]
                  [:li "Other HTML5 Boilerplate goodies like favicons"]
                  [:li "Custom 404 with Google Webmaster Tools"]
                  ]
                 [:h2 "Coming soon"]
                 [:ul
                  [:li "CSS Grid + Styles Generation"]
                  [:li "ClojureScript build support"]]
                 [:h2 "Things you should do"]
                 [:ul
                  [:li "Review robots.txt policy"]
                  [:li "Review crossdomain.xml policy"]
                  [:li "Edit humans.txt"]
                  [:li "Change the icons in the resources/public dir"]
                  ]

))
