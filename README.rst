====
 rr
====

.. image:: https://circleci.com/gh/ayato-p/rr.svg?style=svg
    :target: https://circleci.com/gh/ayato-p/rr

|

.. image:: http://clojars.org/ayato_p/rr/latest-version.svg?style=svg
    :target: http://clojars.org/ayato_p/rr

ReverseReader for HUGE files.

Usage
=====

This library will provide simple two API.

First one is ``rr.core/reader`` function like a ``clojure.java.io/reader``. Returns reader instance of ``org.apache.commons.io.input.ReversedLinesFileReader``.

Second one is ``rr.core/line-seq`` function simular to ``clojure.core/line-seq``, but just for ``rr.core/reader``.

You can use these API as following.

.. sourcecode:: clojure

  (require '[rr.core :as rr])

  (with-open [r (rr/reader "huge.log")]
      (first (rr/line-seq r))) ;; returns last line of file.

License
=======

The MIT License (MIT)

Copyright (c) 2015 Ayato Nishimura, http://ayalog.com/

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
