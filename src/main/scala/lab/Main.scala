package lab

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import lab.p5js.p5
import lab.sketches.{Sketch, StarFieldSketch}

@main def main =
  println("start")
  Sketch.boostrap((new StarFieldSketch(_)))
  println("end")
