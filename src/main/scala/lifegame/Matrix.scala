package lifegame

case class Matrix(matrix: List[List[Boolean]])

def createMatrix(x: Int, y: Int, gen: () => Boolean): Matrix = {
    Matrix(Range(0, y).map(y => List.fill(x)(gen())).toList)
}