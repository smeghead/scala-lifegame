import scala.annotation.tailrec
import lifegame._

@main def run(): Unit = {
  val matrix = createMatrix(40, 80, () => math.random < 0.5)

  @tailrec
  def rec(matrix: Matrix): Unit = {
    Thread.sleep(100);
    print("\u001b[H")
    matrix.matrix.map(line => {
      line.map(if (_) "#" else " ").mkString("")
    }).foreach(println)
    rec(nextGeneration(matrix))
  }
  rec(matrix)
}

