package lab

import scala.scalajs.js
import scala.scalajs.js.annotation._

import lab.p5js.p5

@main def main =
  println("start")
  Sketch.boostrap((new StarFieldSketch(_)))
  println("end")
