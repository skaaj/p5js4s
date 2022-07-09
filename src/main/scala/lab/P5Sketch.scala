package lab

trait P5Sketch {
  val p5Instance: P5Api
  def setup(): Unit
  def draw(): Unit
}
