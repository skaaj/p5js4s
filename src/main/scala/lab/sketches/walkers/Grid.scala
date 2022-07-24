package lab.sketches.walkers

import lab.p5js.Color
import lab.sketches.core.Sketch

class Grid(val width: Int, val height: Int, areaWidth: Float, areaHeight: Float)(implicit s: Sketch) {
  import s.p5Instance._

  val cellWidth = areaWidth / width
  val cellHeight = areaHeight / height

  val walkersTraces =
    Array.ofDim[Option[Color]](height, width)
      .mapInPlace(_.map(_ => None))

  def draw(): Unit = {
    noStroke()
    getDefinedTraces.foreach {
      case (x, y, col) =>
        fill(color(hue(col), saturation(col), 50 + (25 * sin(y))))
        ellipse(x * cellWidth, y * cellHeight, cellWidth, cellHeight)
    }
  }

  def addTrace(x: Int, y: Int, col: Color): Unit = {
    walkersTraces(y)(x) = walkersTraces(y)(x)
      .map(currentCol => lerpColor(currentCol, col, 0.75))
      .orElse(Some(col))
  }

  def makeHole(centerX: Int, centerY: Int, maxDist: Int): Unit = {
    getDefinedTracesInRadius(centerX.toDouble, centerY.toDouble, maxDist)
      .foreach { case (x, y, col) =>
        walkersTraces(y)(x) = None
      }
  }

  def makeGraveyard(centerX: Int, centerY: Int, maxDist: Int): Unit = {
    getDefinedTracesInRadius(centerX.toDouble, centerY.toDouble, maxDist)
      .foreach { case (x, y, col) =>
        walkersTraces(y)(x) = color(255)
      }
  }

  private def getDefinedTraces: Seq[(Int, Int, Color)] = {
    for
      y <- (0 until walkersTraces.length)
      x <- (0 until walkersTraces(y).length)
      if walkersTraces(y)(x).isDefined
    yield (x, y, walkersTraces(y)(x))
  } collect {
    case (x, y, Some(col)) => (x, y, col)
  }

  private def getDefinedTracesInRadius(radiusX: Double, radiusY: Double, maxDist: Int) = {
    getDefinedTraces
      .filter { case (x, y, _) =>
        dist(radiusX, radiusY, x.toDouble, y.toDouble) < maxDist
      }
  }
}
