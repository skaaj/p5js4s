import scala.scalajs.js
import scala.scalajs.js.annotation.*

import sketches.core.Sketch
import sketches.misc.StarFieldSketch

@main def main =
  println("start")
  Sketch.boostrap((new StarFieldSketch(_)))
  println("end")
