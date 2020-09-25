import HelloApi
import org.junit.jupiter.api.Test

class HelloApiTest {
  @Test
  void defaultWhat() {
    assert HelloApi.generateHello() == "Hello, world!"
  }

  @Test
  void customWhat() {
    assert HelloApi.generateHello("something") == "Hello, something!"
  }
}
