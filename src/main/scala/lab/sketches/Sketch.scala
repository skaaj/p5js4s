package lab.sketches

import lab.p5js.{P5Interface, p5}

trait Sketch {
  val p5Instance: P5Interface
  def setup(): Unit
  def draw(): Unit
}

object Sketch {
  def boostrap(constructor: P5Interface => Sketch) =
    new p5(s => {
      val app = constructor(s)
      s.draw = app.draw _
      s.setup = app.setup _
    })
}
