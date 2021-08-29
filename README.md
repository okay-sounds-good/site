# site

"Okay Sounds Good" website/blog.

## Installation

``` shell
brew install --cask java11
brew install jenv  # optional java version manager
brew install clojure
brew install borkdude/brew/clj-kondo  # optional linter
```

## Build log

* Generated the project via [clj-new](https://github.com/seancorfield/clj-new) using the `app` template and referenced the [Practicalli guide](https://practical.li/clojure/clojure-tools/projects/create.html) and tutorials.


## Development

``` shell
# host assets locally, optionally specify port
$ clj -M:serve-live --port 4500

# other options
--browser  # open the index in default browser
--ring-debug --ring-spec  # debug ring handler function issues

# serve the frozen production assets locally
$ clj -M:serve-frozen --port 4500
```

## References

* [Optimus](https://github.com/magnars/optimus) serves static assets in
  production as optimized bundles and in development as unchanged files.
* [Stasis](https://github.com/magnars/stasis) provides a toolbox of SSG
  functions.

