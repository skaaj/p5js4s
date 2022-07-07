package lab

import scala.scalajs.js
import scala.scalajs.js.annotation._

// object CoolApp {
//   import lab.p5Api

//   def setup(): Unit = {
//     createCanvas(400, 400)
//     println("setup called")
//   }

//   def draw(): Unit = {
//     background(0)
//   }
// }

def isWindowDefined: Boolean =
  js.typeOf(js.Dynamic.global.window) != "undefined"

def whenWindowDefined[A](f: => A): Unit = 
  if isWindowDefined then f else ()

class Candidate() {
  val w = 400
  val h = 400
  val semi_w = w / 2
  val semi_h = h / 2

  def setup(p5: p5Api): Unit = {
    import p5._
    createCanvas(w, h)
  }

  def draw(p5: p5Api): Unit = {
    import p5._
    val frame = frameCount
    noStroke()
    p5.background(255)
    p5.fill(0, 255)
    p5.ellipse(semi_w, semi_h, w, h)
    p5.fill(255, 255 / 4)
    for i <- (75 to 175 by 25) do
      p5.ellipse(
        x=semi_w,
        y=semi_h,
        w=w * p5.sin(frame / i.toFloat),
        h=h * p5.cos(frame / i.toFloat)
      )
  }
}

def helper(c: Candidate) = whenWindowDefined {
  new p5(s => {
    s.draw = () => c.draw(s)
    s.setup = () => c.setup(s)
  })
}

@main def main =
  import lab.p5._
  println(s"started")
  helper(new Candidate())
  println("end")
