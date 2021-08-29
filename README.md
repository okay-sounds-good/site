# site

"Okay Sounds Good" website/blog.


## Overview 

* Generated the project via [clj-new](https://github.com/seancorfield/clj-new) using the `app` template.

Key Libraries:
* [stasis](https://github.com/magnars/stasis) provides a toolbox of SSG
  functions to get us started.
* [optimus](https://github.com/magnars/optimus) serves static assets in
  production as optimized bundles and in development as unchanged files.
* [hiccup](https://github.com/weavejester/hiccup) is a template language for
  HTML that uses Clojure data structures. It can output HTML. Incredibly
  powerful tool that really blows away stuff like `liquid`, `jinja`,
  `handlebars` since you have full-on Clojure doing the templating.
* [hickory](https://github.com/davidsantiago/hickory) parses HTML into clojure
  data structures, i.e. Hiccup. This is necessary for flows like Markdown ->
  HTML -> Hiccup for when we want to wrap some HTML content generated from
  Markdown with HTML content generated from Hiccup (e.g. wrapping a `body` with
  a header and footer).
* [markdown-clj](https://github.com/yogthos/markdown-clj) parses
  [MultiMarkdown](https://github.com/fletcher/MultiMarkdown/wiki/MultiMarkdown-Syntax-Guide#metadata)-style
  Markdown into HTML. Useful for writing blog posts in Markdown. 


## Development

#### Prerequisites

``` shell
brew install --cask java11
brew install jenv  # optional java version manager
brew install clojure
brew install borkdude/brew/clj-kondo  # optional linter
```

#### Serve Site Locally with Hot Reloading

``` shell
# host assets locally, optionally specify port
$ clj -M:serve-live --port 4500

# other options
--browser  # open the index in default browser
--ring-debug --ring-spec  # debug ring handler function issues

# serve the frozen production assets locally
$ clj -M:serve-frozen --port 4500
```

## Deployment

Generate the site assets:

``` shell
$ clj -M:generate
```

The static assets will be output to `target/`

Upload the assets to the CDN:

`TODO`
