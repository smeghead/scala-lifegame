import lifegame._

class MatrixSuite extends munit.FunSuite {
  test("initial matrix state") {
    val sut = createMatrix(80, 40, () => false)

    assertEquals(40, sut.matrix.length)
    assertEquals(80, sut.matrix.head.length)
    assertEquals(false, sut.matrix.head.head)
  }

  test("initial matrix state value 1") {
    val sut = createMatrix(80, 40, () => true)

    assertEquals(40, sut.matrix.length)
    assertEquals(80, sut.matrix.head.length)
    assertEquals(true, sut.matrix.head.head)
  }
}
