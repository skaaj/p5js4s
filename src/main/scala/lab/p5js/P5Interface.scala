package lab.p5js

import scala.scalajs.js
import scala.scalajs.js.annotation._
import lab.p5js.Color

@js.native
trait P5Interface extends js.Object {
  var setup: js.Function0[Unit] = js.native
  var draw: js.Function0[Unit] = js.native
  def createCanvas(w: Int, h: Int): Unit = js.native
  def ellipse(x: Int, y: Int, w: Double, h: Double): Unit = js.native
  val frameCount: Int = js.native
  def sin(angle: Double): Double = js.native
  def cos(angle: Double): Double = js.native
  def stroke(gray: Int, alpha: Double): Unit = js.native
  def noStroke(): Unit = js.native
  def clear(): Unit = js.native
  
  // Color
  def color(gray: Float): Color = js.native
  def color(gray: Float, alpha: Float): Color = js.native
  def color(v1: Float, v2: Float, v3: Float): Color = js.native
  def color(v1: Float, v2: Float, v3: Float, alpha: Float): Color = js.native
  def color(colorString: String): Color = js.native
  def color(values: js.Array[Float]): Color = js.native
  def red(color: Color | js.Array[Float] | String): Float = js.native
  def blue(color: Color | js.Array[Float] | String): Float = js.native
  def green(color: Color | js.Array[Float] | String): Float = js.native
  def alpha(color: Color | js.Array[Float] | String): Float = js.native
  def hue(color: Color | js.Array[Float] | String): Float = js.native
  def saturation(color: Color | js.Array[Float] | String): Float = js.native
  def brightness(color: Color | js.Array[Float] | String): Float = js.native
  def lightness(color: Color | js.Array[Float] | String): Float = js.native
  def lerpColor(c1: Color, c2: Color, amount: Float): Color = js.native
  // - Setting
  def background(color: Color): Unit = js.native
  def background(colorString: String): Unit = js.native
  def background(gray: Int): Unit = js.native
  def background(gray: Int, alpha: Int): Unit = js.native
  def background(v1: Int, v2: Int, v3: Int): Unit = js.native
  def background(v1: Int, v2: Int, v3: Int, alpha: Int): Unit = js.native
  def background(values: js.Array[Int]): Unit = js.native
  def fill(gray: Int, alpha: Int): Unit = js.native
  def fill(color: Color): Unit = js.native
}
