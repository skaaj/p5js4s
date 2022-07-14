package lab

import lab.p5js.P5Interface
import scala.scalajs.js
import js.JSConverters._

class ClumsySketch(val p5Instance: P5Interface) extends Sketch {
  import p5Instance._
  
  val w = 400
  val h = 400
  val semi_w = w / 2
  val semi_h = h / 2
  
  def setup(): Unit = {
    createCanvas(w, h)
  }
  
  def drawCircleBackground() = {
    background(255)
    fill(lerpColor(color("red"), color("blue"), sin(frameCount.toDouble / 100d).toFloat))
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
