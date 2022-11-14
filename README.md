## p5js4s, _a Scala.js facade for p5.js_

A strongly-typed Scala.js facade for the popular [p5.js](https://github.com/processing/p5.js). This isn't an official product of the [Processing Foundation](https://github.com/processing) and its current state is not production ready yet.

### Development workflow
Showcase sketches are available. But if you want to test them you'll need to know two things:
1. the sketch that is going to be shown is bootstraped in the main (lab.Main), meaning that you can change it to one of `lab.sketches`
2. the development HTML page imports the compiled JS from `./targets` so you'll need to generate these with `sbt fastLinkJS` before opening `./dist/index-dev.html`.

This examples are only here for development purpose. The final version of the project is going to be a plain library containing only the facade.
