package lab.p5js

import scala.scalajs.js
import scala.scalajs.js.annotation._
import lab.p5js.Color

@js.native
trait P5Interface extends js.Object {
  var setup: js.Function0[Unit] = js.native
  var draw: js.Function0[Unit] = js.native
  var mouseClicked: js.Function0[Unit] = js.native
  var doubleClicked: js.Function0[Unit] = js.native
  var keyPressed: js.Function0[Unit] = js.native
  val mouseX: Double = js.native
  val mouseY: Double = js.native
  def dist(x1: Double, y1: Double, x2: Double, y2: Double): Double = js.native
  def norm(value: Double, start: Double, stop: Double): Double = js.native
  def createCanvas(w: Int, h: Int): Unit = js.native
  def sin(angle: Double): Double = js.native
  def cos(angle: Double): Double = js.native
  def random(): Double = js.native
  def random(max: Double): Double = js.native
  def random(min: Double, max: Double): Double = js.native
  def random[A](choices: js.Array[A]): A = js.native
  def map(value: Double, start1: Double, stop1: Double, start2: Double, stop2: Double): Double = js.native
  // FIXME: can withinBounds be set with a default value ?
  def map(value: Double, start1: Double, stop1: Double, start2: Double, stop2: Double, withinBounds: Boolean): Double = js.native
  def translate(x: Double, y: Double): Unit = js.native
  // TODO: translate(vector)
  // TODO: WebGL mode translate(x, y, z)
  val frameCount: Int = js.native
  val deltaTime: Double = js.native
  val focused: Boolean = js.native
  val displayWidth: Int = js.native
  val displayHeight: Int = js.native
  // TODO: handle cursor type with enum
  def cursor(`type`: String): Unit = js.native
  def cursor(`type`: String, x: Double, y: Double): Unit = js.native
  def noCursor(): Unit = js.native
  def frameRate(): Double = js.native
  def frameRate(fps: Double): Unit = js.native

  // Color
  def color(gray: Double): Color = js.native
  def color(gray: Double, alpha: Double): Color = js.native
  def color(v1: Double, v2: Double, v3: Double): Color = js.native
  def color(v1: Double, v2: Double, v3: Double, alpha: Double): Color = js.native
  def color(colorString: String): Color = js.native
  def color(values: js.Array[Double]): Color = js.native
  def red(color: Color | js.Array[Double] | String): Double = js.native
  def green(color: Color | js.Array[Double] | String): Double = js.native
  def blue(color: Color | js.Array[Double] | String): Double = js.native
  def alpha(color: Color | js.Array[Double] | String): Double = js.native
  def hue(color: Color | js.Array[Double] | String): Double = js.native
  def saturation(color: Color | js.Array[Double] | String): Double = js.native
  def brightness(color: Color | js.Array[Double] | String): Double = js.native
  def lightness(color: Color | js.Array[Double] | String): Double = js.native
  def lerpColor(c1: Color, c2: Color, amount: Double): Color = js.native
  //-- Setting
  def background(color: Color): Unit = js.native
  def background(colorString: String): Unit = js.native
  def background(gray: Double): Unit = js.native
  def background(gray: Double, alpha: Double): Unit = js.native
  def background(v1: Double, v2: Double, v3: Double): Unit = js.native
  def background(v1: Double, v2: Double, v3: Double, alpha: Double): Unit = js.native
  def background(values: js.Array[Double]): Unit = js.native
  // TODO: background with p5.Image
  def clear(): Unit = js.native
  // FIXME: use Enum for mode
  def colorMode(mode: String, max: Double): Unit = js.native
  def colorMode(mode: String, max1: Double, max2: Double, max3: Double): Unit = js.native
  def colorMode(mode: String, max1: Double, max2: Double, max3: Double, maxA: Double): Unit = js.native
  def fill(v1: Double, v2: Double, v3: Double): Unit = js.native
  def fill(v1: Double, v2: Double, v3: Double, alpha: Double): Unit = js.native
  def fill(colorString: String): Unit = js.native
  def fill(gray: Double): Unit = js.native
  def fill(gray: Double, alpha: Double): Unit = js.native
  def fill(values: js.Array[Double]): Unit = js.native
  def fill(color: Color): Unit = js.native
  def noFill(): Unit = js.native
  def noStroke(): Unit = js.native
  def stroke(v1: Double, v2: Double, v3: Double): Unit = js.native
  def stroke(v1: Double, v2: Double, v3: Double, alpha: Double): Unit = js.native
  def stroke(colorString: String): Unit = js.native
  def stroke(gray: Int): Unit = js.native
  def stroke(gray: Int, alpha: Double): Unit = js.native
  def stroke(values: js.Array[Double]): Unit = js.native
  def stroke(color: Color): Unit = js.native
  def erase(strengthFill: Double = 255, strengthStroke: Double = 255): Unit = js.native

  // Shape
  //-- 2D Primitives
  def arc(x: Double, y: Double, w: Double, h: Double, start: Double, stop: Double): Unit = js.native
  // FIXME: use Enum for mode
  def arc(x: Double, y: Double, w: Double, h: Double, start: Double, stop: Double, mode: String): Unit = js.native
  def ellipse(x: Double, y: Double, w: Double): Unit = js.native
  def ellipse(x: Double, y: Double, w: Double, h: Double): Unit = js.native
  def circle(x: Double, y: Double, d: Double): Unit = js.native
  def line(x1: Double, y1: Double, x2: Double, y2: Double): Unit = js.native
  // TODO: WebGL mode line(x1, y1, x2, y2, z1, Z2)
  def point(x: Double, y: Double): Unit = js.native
  // TODO: WebGL mode point(x, y, z)
  // TODO: point(p5.Vector)
  def quad(
    x1: Double, y1: Double, x2: Double, y2: Double,
    x3: Double, y3: Double, x4: Double, y4: Double
  ): Unit = js.native
  // TODO: WebGL mode quad(x1, y1, x2, y2, x3, y3, x4, y4, detailX, detailY)
  // TODO: WebGL mode quad(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4)
  // TODO: WebGL mode quad(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4, detailX, detailY)
  def rect(x: Double, y: Double, w: Double): Unit = js.native
  def rect(
    x: Double, y: Double, w: Double, h: Double,
    tl: Double = 0, tr: Double = 0, br: Double = 0, bl: Double = 0
  ): Unit = js.native
  // TODO: WebGL mode rect(x, y, w, h, [detailX], [detailY])
  def square(x: Double, y: Double, s: Double): Unit = js.native
  def square(
    x: Double, y: Double, s: Double,
    tl: Double = 0, tr: Double = 0, br: Double = 0, bl: Double = 0
  ): Unit = js.native
  def triangle(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double): Unit = js.native
}
