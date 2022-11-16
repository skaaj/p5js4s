package lab.sketches.core

import lab.p5js.{P5Interface, p5}

trait Sketch {
  val p5Instance: P5Interface
  def setup(): Unit
  def draw(): Unit
  def mouseClicked(): Unit = ()
  def doubleClicked(): Unit = ()
  def keyPressed(): Unit = ()
}

object Sketch {
  def boostrap(constructor: P5Interface => Sketch) =
    new p5(s => {
      val app = constructor(s)
      s.draw = app.draw _
      s.setup = app.setup _
      s.mouseClicked = app.mouseClicked _
      s.doubleClicked = app.doubleClicked _
      s.keyPressed = app.keyPressed _
    })
}
