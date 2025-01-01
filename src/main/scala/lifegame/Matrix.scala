package lifegame

case class Matrix(matrix: IArray[IArray[Boolean]])

def createMatrix(x: Int, y: Int, gen: () => Boolean): Matrix = {
    val matrix = IArray.fill(x)(
        IArray.fill(y)(gen())
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
    ).flatten.count(_ == true)
}

def nextValue(current: Option[Boolean], aroundLivings: Int): Boolean = {
    current match {
        case Some(false) => aroundLivings == 3
        case Some(true) => if (aroundLivings <= 1) false
            else if (aroundLivings <= 3) true
            else false
        case None => throw new Exception("bug")
    }
}

def nextGeneration(matrix: Matrix): Matrix = {
    val newMatrix = IArray.from(matrix.matrix.indices.map(x => 
        IArray.from(matrix.matrix.head.indices.map(y => {
            val aroundLivings = aroundLivingCount(matrix, x, y)
            nextValue(getPoint(matrix, x, y), aroundLivings)
        }))
    ))
    Matrix(newMatrix)    
}
