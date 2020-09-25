package starter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BasicTests {
  @Test
  void pomPath() {
    assertNotNull(JavaTestPlugin.GUAVA_POM_PATH);
  }
}
