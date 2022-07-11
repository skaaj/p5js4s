package lab

import scala.scalajs.js
import scala.scalajs.js.annotation._

import lab.js.p5

@main def main =
  println("start")
  Sketch.boostrap((new ClumsySketch(_)))
  println("end")
