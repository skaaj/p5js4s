import scala.scalajs.js
import scala.scalajs.js.annotation.*
import sketches.core.Sketch
import sketches.reference.Shapes

@main def main =
  println("start")
  Sketch.boostrap((new Shapes(_)))
  println("end")
