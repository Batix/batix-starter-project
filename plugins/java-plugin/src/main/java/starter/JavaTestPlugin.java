package starter;

import com.batix.plugins.Plugin;
import com.google.common.io.Resources;

import java.io.InputStream;
import java.util.Properties;

public class JavaTestPlugin extends Plugin {
  public static final String GUAVA_POM_PATH = "META-INF/maven/com.google.guava/guava/pom.properties";

  @Override
  public void load() {
    logI("load");

    findGuavaVersion();
  }

  @Override
  public void unload() {
    logI("unload");
  }

  private void findGuavaVersion() {
    Properties properties = new Properties();

    try (InputStream inputStream = Resources.getResource(GUAVA_POM_PATH).openStream()) {
      properties.load(inputStream);
    } catch (Exception e) {
      logE("error determining Guava version", e);
    }

    logI("found Guava version: " + properties.getProperty("version"));
  }
}
