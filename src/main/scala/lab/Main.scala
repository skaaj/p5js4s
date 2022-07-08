package lab

import scala.scalajs.js
import scala.scalajs.js.annotation._

@main def main =
  import Helpers._
  println("start")
  bootstrapSketch((new ClumsySketch(_)))
  println("end")
