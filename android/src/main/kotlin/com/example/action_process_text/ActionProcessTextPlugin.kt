package com.example.action_process_text

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** ActionProcessTextPlugin */
class ActionProcessTextPlugin: FlutterPlugin, MethodCallHandler, FlutterActivity {
  companion object {
    @JvmStatic
    fun registerWith(registrarFor: PluginRegistry.Registrar) {

    }

    const val CHANNEL = "action_process_text"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val channel = MethodChannel(flutterView, CHANNEL)
    if (intent.action == Intent.ACTION_PROCESS_TEXT) {
      val selectedText = intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT) ?: ""
      channel.invokeMethod("copiedText", selectedText)
    }

  }
}
