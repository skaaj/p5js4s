package lab

import lab.p5js.P5Interface
import scala.scalajs.js
import js.JSConverters._

class StarFieldSketch(val p5Instance: P5Interface) extends Sketch {
  import p5Instance._
  
  case class Star(
    var x: Double,
    var y: Double,
    var z: Double,
    var pz: Double
  ) {
    def update(): Unit = {
      pz = z + 5
      z -= 10
      if z < 1 then
        x = random(-width, width)
        y = random(-height, height)
        z = width
        pz = z
    }
    
    def draw(): Unit = {
      fill(255)
      noStroke()
      val sx = map(x / z, 0, 1, 0, width)
      val sy = map(y / z, 0, 1, 0, height)
      val r = map(z, 0, width, 4, 0)
      ellipse(sx, sy, r, r)
      val px = map(x / pz, 0, 1, 0, width)
      val py = map(y / pz, 0, 1, 0, height)
      stroke(120)
      line(px, py, sx, sy)
    }
  }
  
  val width = 600
  val height = 600
  val stars = (0 to 2000).map { _ =>
    val z = random(width)
    Star(random(-width, width), random(-height, height), z, z)
  }

  def setup(): Unit = {
    createCanvas(width, height)
  }
  
  def draw(): Unit = {
    background(0)
    translate(width/2, height/2)
    stars.foreach { star => 
      star.update()
      star.draw()
    }
  }
}
