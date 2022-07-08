package lab

import scala.scalajs.js

object Helpers {
  def isWindowDefined: Boolean =
    js.typeOf(js.Dynamic.global.window) != "undefined"
  
  def whenWindowDefined[A](f: => A): Unit = 
    if isWindowDefined then f else ()

  def bootstrapSketch(ctr: p5Api => P5Sketch) = whenWindowDefined {
    new p5(s => {
      val app = ctr(s)
      s.draw = app.draw _
      s.setup = app.setup _
    })
  }
}
