package lab

trait P5Sketch {
  val p5Toolbox: p5Api
  def setup(): Unit
  def draw(): Unit
}
