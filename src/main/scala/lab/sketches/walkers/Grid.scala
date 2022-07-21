package lab.sketches.walkers

import lab.p5js.Color
import lab.sketches.core.Sketch

class Grid(val width: Int, val height: Int, areaWidth: Float, areaHeight: Float)(implicit s: Sketch) {
  import s.p5Instance._

  val cellWidth = areaWidth / width
  val cellHeight = areaHeight / height

  val walkersTraces = Array.ofDim[Option[Color]](height, width)
    .mapInPlace(line => line.map(cell => None))

  def draw(): Unit = {
    noStroke()
    for
      y <- (0 until walkersTraces.length)
      x <- (0 until walkersTraces(y).length)
      if walkersTraces(y)(x).isDefined
    do
      val col = walkersTraces(y)(x).get
      fill(color(hue(col), saturation(col), 50 + (25 * sin(y))))
      ellipse(x * cellWidth, y * cellHeight, cellWidth, cellHeight)
  }

  def addTrace(x: Int, y: Int, col: Color): Unit = {
    walkersTraces(y)(x) = walkersTraces(y)(x)
      .map(currentCol => lerpColor(currentCol, col, 0.75))
      .orElse(Some(col))
  }

  def makeHole(centerX: Int, centerY: Int, maxDist: Int): Unit = {
    for
      y <- (0 until walkersTraces.length)
      x <- (0 until walkersTraces(y).length)
      if walkersTraces(y)(x).isDefined
      distance = dist(centerX.toDouble, centerY.toDouble, x.toDouble, y.toDouble)
      if  distance < maxDist
    do
      walkersTraces(y)(x) = walkersTraces(y)(x).flatMap(_ => None)
  }

  def makeGraveyard(centerX: Int, centerY: Int, maxDist: Int): Unit = {
    for
      y <- (0 until walkersTraces.length)
      x <- (0 until walkersTraces(y).length)
      if walkersTraces(y)(x).isDefined
      distance = dist(centerX.toDouble, centerY.toDouble, x.toDouble, y.toDouble)
      if  distance < maxDist
    do
      walkersTraces(y)(x) = walkersTraces(y)(x).map(_ => color(255))
  }
}
