package sketches.reference

import p5js4s.P5Interface
import sketches.core.Sketch

import scala.scalajs.js
import scala.scalajs.js.JSConverters.*

class Shapes(val p5Instance: P5Interface) extends Sketch {
  import p5Instance.*

  val width = 1000
  val height = 1000

  def setup(): Unit = {
    createCanvas(width, height)
  }

  def draw(): Unit = {
    background(200)
    fill(255)
    stroke(0)
    rect(10, 10, 100)
    rect(120, 10, 50, 100)
    rect(10, 120, 100, 100, 20)
    rect(120, 120, 50, 100, 20, 0, 20, 0)
  }
}

