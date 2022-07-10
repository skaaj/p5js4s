package lab

import lab.js.P5Api

trait P5Sketch {
  val p5Instance: P5Api
  def setup(): Unit
  def draw(): Unit
}
