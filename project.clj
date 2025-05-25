(defproject neanderthal-stick "0.5.0-SNAPSHOT"
  :description "Save/Load Extensions for Neanderthal, Fast Clojure Matrix Library"
  :url "https://github.com/katox/neanderthal-stick"
  :license {:name "Eclipse Public License 2.0"
            :url "https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [uncomplicate/neanderthal "0.53.2"]
                 [com.taoensso/nippy "3.5.0"]]

  :codox {:metadata {:doc/format :markdown}
          :src-dir-uri "https://github.com/katox/neanderthal-stick/blob/master/"
          :src-linenum-anchor-prefix "L"
          :namespaces [neanderthal-stick.core
                       neanderthal-stick.buffer
                       neanderthal-stick.experimental
                       neanderthal-stick.nippy-ext]
          :output-path "doc/codox"}

  ;;also replaces lein's default JVM argument TieredStopAtLevel=1
  :jvm-opts ^:replace ["-Dclojure.compiler.direct-linking=true"]

  :repl-options {:init-ns neanderthal-stick.core}

  :profiles {:dev {:plugins [[lein-midje "3.2.1"]
                             [lein-codox "0.10.8"]]
                   :global-vars {*warn-on-reflection* true
                                 *assert* false
                                 *unchecked-math* :warn-on-boxed
                                 *print-length* 128}
                   :dependencies [[midje "1.10.10"]
                                  ;; depedencies added to test on windows without a global MKL installed.
                                  ;; note: also install CUDA Toolkit 12.6 Update 3.
                                  [org.bytedeco/mkl "2025.0-1.5.11" :classifier windows-x86_64-redist]
                                  [org.bytedeco/cuda "12.6-9.5-1.5.11" :classifier windows-x86_64-redist]
                                  ;; same dependencies if on linux.
                                  ;[org.bytedeco/mkl "2025.0-1.5.11" :classifier linux-x86_64-redist]
                                  ;[org.bytedeco/cuda "12.6-9.5-1.5.11" :classifier linux-x86_64-redist]
                                  [org.clojure/test.check "1.0.0"]]}
             :java8 {:jvm-opts ^:replace ["-Dclojure.compiler.direct-linking=true"]}}

  :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:-options"]
  :source-paths ["src"]
  :test-paths ["test"])
