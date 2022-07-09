package lab

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
trait P5Api extends js.Object {
  var setup: js.Function0[Unit] = js.native
  var draw: js.Function0[Unit] = js.native
  def createCanvas(w: Int, h: Int): Unit = js.native
  def background(lum: Int): Unit = js.native
  def ellipse(x: Int, y: Int, w: Double, h: Double): Unit = js.native
  val frameCount: Int = js.native
  def sin(angle: Double): Double = js.native
  def cos(angle: Double): Double = js.native
  def stroke(gray: Int, alpha: Double): Unit = js.native
  def noStroke(): Unit = js.native
  def fill(gray: Int, alpha: Int): Unit = js.native
}
