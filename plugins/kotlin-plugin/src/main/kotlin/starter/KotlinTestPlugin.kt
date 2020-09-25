package starter

import com.batix.plugins.Plugin

class KotlinTestPlugin : Plugin() {
  override fun load() {
    logI("load")

    logI("Kotlin version: ${KotlinVersion.CURRENT}")
  }

  override fun unload() {
    logI("unload")
  }

  companion object {
    fun doubledSum(a: Int, b: Int): Long = 2L * (a + b)
  }
}
