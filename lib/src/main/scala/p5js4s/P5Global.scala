package p5js4s

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("window")
object P5Global extends P5Interface {
  // Approach described there:
  // https://stackoverflow.com/questions/60738072/jsglobalscope-in-scala-js-1-0-javascriptexception-referenceerror-var-is-not
}
