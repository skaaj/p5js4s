package lab.sketches.walkers

import lab.p5js.Color

case class Walker(
  x: Int,
  y: Int,
  color: Color,
  grid: Grid
) {
  def move(dx: Int, dy: Int): Option[Walker] = {
    val newX = x + dx
    val newY = y + dy
    if isInside(newX, newY) then
      grid.addTrace(newX, newY, color)
      Some(copy(newX, newY))
    else
      grid.makeGraveyard(x, y, 10)
      None
  }

  private def isInside(x: Int, y: Int): Boolean =
    x >= 0 && x < grid.width && y >= 0 && y < grid.height
}
