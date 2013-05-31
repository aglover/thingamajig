# Thingamajig - it's a what?

This is a simple word-definition engine which permits studying and quizzing word definitions

## Details

`Word` instances (and their corresponding `Definition`s) are created via JSON documents that look like so:

```
{
  "spelling": "sagacious",
  "definitions": [
    {
      "part_of_speech": "adjective",
      "definition": "having or showing acute mental discernment and keen practical sense; shrewd: a sagacious lawyer."
    }
  ]
}
```

This document will create a `Word` instance containing a collection of one `Definition`. 

## Putting it all together

Invoke `Word.manufacture` with a JSON document and you'll get back an init'ed `Word`. Initialize a `WordStudyEngine`, which is used to get randomized `Word` instances with a collection of `Word`s:

```
WordStudyEngine instance = WordStudyEngine.getInstance(words);
```

Note, there is a corresponding `WordTestEngine` as well -- same principle, this object returns instances of `TestableWord`. These have a `Word` instance along with a collection of throw off words. 

## Installation

Clone the repo, change directories into the project's root and type `ant dist`. That'll compile, run tests, and build a .jar file you can include in any desired project. 

# License

The MIT License

Copyright (c) 2013 Andrew Glover

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE