import lifegame._

class MatrixSuite extends munit.FunSuite {
  test("initial matrix state") {
    val sut = createMatrix(80, 40, ? => 0)

    assertEquals(40, sut.matrix.length)
    assertEquals(80, sut.matrix.head.length)
  }
}
