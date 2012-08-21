(ns h5noir.views.common
  (:use [noir.core :only [defpartial]]
        [noir.statuses]
        [hiccup.core]
        [hiccup.page-helpers :only [include-css html5 include-js javascript-tag doctype]]))

;; google analytics code
(def gacode nil)

(defpartial header []
  [:header])

(defpartial footer []
  [:footer])

(defn html-meta [name content]
  [:meta {:name name :content content}])

(defpartial layout [title options & content]
  (let [description (:description options)
        author (:author options)
        keywords (:keywords options)]
    (str
     (doctype :html5)
     ;; paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/
           
     "<!--[if lt IE 7]> <html class=\"no-js ie6 oldie\" lang=\"en\"> <![endif]-->
      <!--[if IE 7]>    <html class=\"no-js ie7 oldie\" lang=\"en\"> <![endif]-->
      <!--[if IE 8]>    <html class=\"no-js ie8 oldie\" lang=\"en\"> <![endif]-->"
           
     ;; Consider adding an manifest.appcache: h5bp.com/d/Offline
           
     "<!--[if gt IE 8]><!--> <html class=\"no-js\" lang=\"en\"> <!--<![endif]-->"
     
     (html
      [:head
       [:meta {:charset "utf-8"}]
       [:title title]
       (when description
         (html-meta "description" description))
       (when author
         (html-meta "author" author))
       (when keywords
         (html-meta "keywords" keywords))

       ;; note

       ;; Mobile viewport optimized: j.mp/bplateviewport
       (html-meta "viewport" "width=device-width,initial-scale=1")

       ;; Place favicon.ico and apple-touch-icon.png in the
       ;; resources/public directory:
       ;; mathiasbynens.be/notes/touch-icons
               
       ;; html5 boilerplate styles
       (include-css "/css/style.css")

       ;; All JavaScript at the bottom, except for Modernizr /
       ;; Respond. Modernizr enables HTML5 elements & feature detects;
       ;; Respond is a polyfill for min/max-width CSS3 Media Queries
       ;; For optimal performance, use a custom Modernizr build:
       ;; www.modernizr.com/download/
       (include-js "/js/libs/modernizr-2.0.6.min.js")
               
       ])
     (html
      [:body
       [:div#container
        (header)
        
        (vec (lazy-cat [:div#main {:role "main"}] content))

        (footer)]

       ;; JavaScript at the bottom for fast page loading

       ;; Grab Google CDN's jQuery, with a protocol relative URL; fall
       ;; back to local if offline
        
       (include-js "//ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js")
       (javascript-tag "window.jQuery || document.write('<script src=\"/js/libs/jquery-1.7.0.min.js\"><\\/script>')")

       ;; this includes something to make console.log always work
        
       (include-js "/js/plugins.js")
             
       ;; def the gacode at the top for Google Analytics
        
       (when gacode
         (javascript-tag (str "window._gaq = [['_setAccount','"
                              gacode
                              "'],['_trackPageview'],['_trackPageLoadTime']];
                              Modernizr.load({
                              load: ('https:' == location.protocol ? '//ssl' : '//www') + '.google-analytics.com/ga.js'
                              });")))

       ;; Prompt IE 6 users to install Chrome Frame. Remove this if
       ;; you want to support IE 6.
       ;; chromium.org/developers/how-tos/chrome-frame-getting-started
       "<!--[if lt IE 7 ]>"
       (include-js "//ajax.googleapis.com/ajax/libs/chrome-frame/1.0.3/CFInstall.min.js")
       (javascript-tag "window.attachEvent('onload',function(){CFInstall.check({mode:'overlay'})})")
       "<![endif]-->"


       ;; add more JS here



       ])
     )))

(defpartial page404 []
  (layout "Page Not Found" {}
          [:p "Sorry, but the page you were trying to view does not exist."]
          [:p "It looks like this was the result of either:"]
          [:ul
           [:li "a mistyped address"]
           [:li "an out-of-date link"]
           ]

          (javascript-tag "var GOOG_FIXURL_LANG = (navigator.language || '').slice(0,2),
                      GOOG_FIXURL_SITE = location.host;")
          (include-js "http://linkhelp.clients.google.com/tbproxy/lh/wm/fixurl.js")
          ))

;; add 404 page
(set-page! 404 (page404))
