package sketches.walkers

import p5js4s.P5Interface
import sketches.core
import sketches.core.Sketch

import scala.scalajs.js
import scala.scalajs.js.JSConverters.*
import scala.util.Random

class WalkersPartySketch(val p5Instance: P5Interface) extends core.Sketch {
  import p5Instance.*

  val w = 600
  val h = 600
  val center_w = w / 2
  val center_h = h / 2

  val grid = new Grid(60, 60, w, h)(this)
  var walkers = Seq.empty[Walker]

  def setup(): Unit = {
    createCanvas(w, h)
    colorMode("hsl", 100)
    cursor("crosshair")
    frameRate(60)
  }
  
  def draw(): Unit = {
    walkers = (
      for
        walker <- walkers
      yield
        val dx = Random.between(-1, 2)
        val dy = Random.between(-1, 2)
        walker.move(dx, dy)
    ).flatten

    background(0)
    grid.draw()
  }

  override def mouseClicked(): Unit = {
    println(s"mouse clicked at ($mouseX; $mouseY)")
    val gridX = (mouseX / grid.cellWidth).toInt
    val gridY = (mouseY / grid.cellHeight).toInt
    walkers = spawnWalker(gridX, gridY) +: walkers
  }

  override def keyPressed(): Unit = {
    println(s"key pressed with cursor at ($mouseX; $mouseY)")
    val gridX = (mouseX / grid.cellWidth).toInt
    val gridY = (mouseY / grid.cellHeight).toInt
    grid.makeHole(gridX, gridY, 10)
  }

  private def spawnWalker(x: Int, y: Int): Walker = {
    val hue = Random.between(0, 100)
    val babyWalker = Walker(x, y, color(hue, 100, 50), grid)
    babyWalker.move(0, 0)
    babyWalker
  }
}
