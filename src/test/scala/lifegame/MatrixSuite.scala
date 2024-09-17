import lifegame._
import cats.effect.IO

class MatrixSuite extends munit.FunSuite {
  test("initial matrix state") {
    val sut = createMatrix(40, 80, () => false)

    assertEquals(sut.matrix.length, 40)
    assertEquals(sut.matrix.head.length, 80)
    assertEquals(false, sut.matrix.head.head)
  }

  test("initial matrix state value 1") {
    val sut = createMatrix(40, 80, () => true)

    assertEquals(sut.matrix.length, 40)
    assertEquals(sut.matrix.head.length, 80)
    assertEquals(sut.matrix.head.head, true)
  }

  test("initial matrix state random value") {
    val sut = createMatrix(40, 80, () => math.random < 0.5)

    assertEquals(sut.matrix.length, 40)
    assertEquals(sut.matrix.head.length, 80)

    val trueCount = sut.matrix.head.filter(n => n == true).length
    assertEquals(trueCount > 20, true)
    assertEquals(trueCount < 60, true)
  }

  test("small matrix. aroundLivingCount") {
    val matrix = Matrix(List(
      List(true, true, true, true),
      List(true, true, false, false),
      List(true, false, false, false),
    ))

    assertEquals(aroundLivingCount(matrix, 0, 0), 3)
    assertEquals(aroundLivingCount(matrix, 1, 1), 5)
    assertEquals(aroundLivingCount(matrix, 2, 3), 0)
  }

  test("small matrix. nextGeneration") {
    val matrix = Matrix(List(
      List(true, true, true, true),
      List(true, true, false, false),
      List(true, false, false, true),
    ))
    val next = nextGeneration(matrix)

    assertEquals(next.matrix.apply(1).apply(3), true, "born")
    assertEquals(next.matrix.apply(0).apply(0), true, "keep living")
    assertEquals(next.matrix.apply(1).apply(1), false, "overcrowding")
    assertEquals(next.matrix.apply(2).apply(3), false, "Depopulation")
  }

}
