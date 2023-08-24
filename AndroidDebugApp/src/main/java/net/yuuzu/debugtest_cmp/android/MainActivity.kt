package net.yuuzu.debugtest_cmp.android

import android.content.Intent
import android.os.Bundle
import androidx.compose.material.*
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent
import net.yuuzu.debugtest_cmp.MainView
import net.yuuzu.media.picker.LocalMediaController

class MainActivity : PreComposeActivity() {
    private val localMediaController = LocalMediaController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView(localMediaController)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        localMediaController.permissionsController.onDataReceived(
            requestCode,
            permissions,
            grantResults
        )
    }

    @Suppress("DEPRECATION")
    @Deprecated(
        "Deprecated in Java", ReplaceWith(
            "super.onActivityResult(requestCode, resultCode, data)",
            "androidx.appcompat.app.AppCompatActivity"
        )
    )
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        localMediaController.onActivityResult(requestCode, resultCode, data)
    }
}

