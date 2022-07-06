import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.PropertyDescriptor

@js.native
trait p5Api extends js.Object {
  var setup: js.Function0[Unit] = js.native
  var draw: js.Function0[Unit] = js.native
  def createCanvas(w: Int, h: Int): Unit = js.native
  def background(lum: Int): Unit = js.native
  def ellipse(x: Int, y: Int, w: Int, h: Int): Unit = js.native
}

@js.native
@JSGlobal
class p5(sketch: js.Function1[p5, Unit]) extends p5Api {

}

@js.native
@JSGlobalScope
object p5 extends p5Api {
  
}

object CoolApp {
  import p5._

  def setup(): Unit = {
    createCanvas(400, 400)
    println("setup called")
  }

  def draw(): Unit = {
    background(0)
  }
}

def addToWindow(key: String, value: js.Any) =
  if isWindowDefined then
    println("add to window")
    js.Dynamic.global.window.updateDynamic(key)(value)
  else
    println("window not found, adding nothing")
    ()

def isWindowDefined: Boolean =
  js.typeOf(js.Dynamic.global.window) != "undefined"

def whenWindowDefined(f: => Unit): Unit = 
  if isWindowDefined then f else ()

@main def main =
  println(s"started")
  whenWindowDefined {
    val myscope = new p5(s => {
      println("bec")
      val w = 400
      val h = 400
      s.draw = () => {
        s.background(0)
        s.ellipse(w/2, h/2, w/2, h/2)
      }
      s.setup = () => {
        s.createCanvas(w, h)
      }
      println("eoc")
    })
  }
  println("end")
