package sketches.misc

import p5js4s.P5Interface
import sketches.core.Sketch

import scala.scalajs.js
import scala.scalajs.js.JSConverters.*

class StarFieldSketch(val p5Instance: P5Interface) extends Sketch {
  import p5Instance.*
  
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
      val r = map(z, 0, width, 5, 0)
      ellipse(sx, sy, r, r)
      val px = map(x / pz, 0, 1, 0, width)
      val py = map(y / pz, 0, 1, 0, height)
      stroke(120)
      line(px, py, sx, sy)
    }
  }
  
  val width = 800
  val height = 800
  val stars = (0 to 2500).map { _ =>
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
