package lab

import scala.scalajs.js
import scala.scalajs.js.annotation._
import lab.js.P5Api
import lab.js.p5

object Helpers {
  def isWindowDefined: Boolean =
    js.typeOf(js.Dynamic.global.window) != "undefined"
  
  def whenWindowDefined[A](f: => A): Unit = 
    if isWindowDefined then f else ()

  def bootstrapSketch(constructor: P5Api => P5Sketch) = whenWindowDefined {
    new p5(s => {
      val app = constructor(s)
      s.draw = app.draw _
      s.setup = app.setup _
    })
  }
}
