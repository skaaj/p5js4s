package lab

import scala.scalajs.js
import scala.scalajs.js.annotation._
import Helpers._
import P5Global._

val w = 400
val h = 400
val semi_w = w / 2
val semi_h = h / 2

def _setup(): Unit = {
  createCanvas(w, h)
}

def drawCircleBackground() = {
  background(255)
  fill(0, 255)
  ellipse(semi_w, semi_h, w, h)
}

def drawCenteredCircle(w: Double, h: Double) = {
  ellipse(semi_w, semi_h, w, h)
}

def _draw(): Unit = {
  noStroke()
  drawCircleBackground()
  fill(255, 255 / 4)
  for i <- (75 to 175 by 25) do
    drawCenteredCircle(
      w * sin(frameCount / i.toFloat),
      h * cos(frameCount / i.toFloat)
    )
}

@main def main =
  println("start")
  setup = _setup _
  draw = _draw _
  println("end")
