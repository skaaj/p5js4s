import scala.scalajs.js
import scala.scalajs.js.annotation._

class p5

@js.native
@JSGlobalScope
object p5 extends js.Object {
  def createCanvas(w: Int, h: Int): Unit = js.native
  def background(lum: Int): Unit = js.native
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
  if js.typeOf(js.Dynamic.global.window) != "undefined" then
    println("add to window")
    js.Dynamic.global.window.updateDynamic(key)(value)
  else
    println("window not found, adding nothing")
    ()

@main def main =
  println(s"started")
  addToWindow("setup", CoolApp.setup _)
  addToWindow("draw", CoolApp.draw _)
  println("end")
