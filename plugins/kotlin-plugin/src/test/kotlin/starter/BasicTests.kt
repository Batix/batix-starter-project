package starter

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BasicTests {
  @ParameterizedTest(name = "2 * ({0} + {1}) = {2}")
  @CsvSource(
    "1, 2, 6",
    "0, 5, 10"
  )
  fun maths(a: Int, b: Int, expected: Long) {
    Assertions.assertEquals(expected, KotlinTestPlugin.doubledSum(a, b))
  }
}
