package sketches.misc

import p5js4s.P5Interface
import sketches.core.Sketch

import scala.scalajs.js
import scala.scalajs.js.JSConverters.*

class SineEllipseSketch(val p5Instance: P5Interface) extends Sketch {
  import p5Instance.*
  
  val w = 400
  val h = 400
  val semi_w = w / 2
  val semi_h = h / 2
  
  def setup(): Unit = {
    createCanvas(w, h)
  }
  
  def drawCircleBackground() = {
    background(255)
    val c = lerpColor(color("red"), color("blue"), sin(frameCount / 100d))
    fill(c)
    ellipse(semi_w, semi_h, w, h)
  }
  
  def drawCenteredCircle(w: Double, h: Double) = {
    ellipse(semi_w, semi_h, w, h)
  }
  
  def draw(): Unit = {
    clear()
    noStroke()
    drawCircleBackground()
    fill(255, 255 / 4)
    for i <- (75 to 175 by 25) do
      drawCenteredCircle(
        w * sin(frameCount / i.toFloat),
        h * cos(frameCount / i.toFloat)
      )
  }
}
