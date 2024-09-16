package lifegame

case class Matrix(matrix: List[List[Int]])

def createMatrix(x: Int, y: Int, gen: _ => Int): Matrix = {
    Matrix(Range(0, y).map(y => List.fill(x)(0)).toList)
}