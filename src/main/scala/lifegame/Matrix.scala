package lifegame
import cats.effect.IO
import cats.implicits._

case class Matrix(matrix: List[List[Boolean]])

def createMatrix(x: Int, y: Int, gen: () => Boolean): Matrix = {
    val matrix = Range(0, x).toList.map(_ => 
        Range(0, y).toList.map(_ => gen()).toList
    )
    Matrix(matrix)
}

def getPoint(matrix: Matrix, x: Int, y: Int): Option[Boolean] = {
    for {
        xVal <- matrix.matrix.lift(x)
        yVal <- xVal.lift(y)
    } yield yVal
}

def aroundLivingCount(matrix: Matrix, x: Int, y: Int): Int = {
    List(
        getPoint(matrix, x - 1, y - 1),
        getPoint(matrix, x - 1, y),
        getPoint(matrix, x - 1, y + 1),
        getPoint(matrix, x, y - 1),
        getPoint(matrix, x, y + 1),
        getPoint(matrix, x + 1, y - 1),
        getPoint(matrix, x + 1, y),
        getPoint(matrix, x + 1, y + 1),
    ).map(_.toList).flatten.filter(_ == true).length
}

def nextGeneration(matrix: Matrix): Matrix = {
    val newMatrix = Range(0, matrix.matrix.length).toList.map(x => 
        Range(0, matrix.matrix.head.length).toList.map(y => {
            val aroundLivings = aroundLivingCount(matrix, x, y)
            getPoint(matrix, x, y) match {
                case Some(false) => if (aroundLivings == 3) true else false
                case Some(true) => if (aroundLivings <= 1) false
                    else if (aroundLivings <= 3) true
                    else false
                case None => throw new Exception("bug")
            }
        }).toList
    )
    Matrix(newMatrix)    
}
