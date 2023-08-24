package net.yuuzu.media.picker

import android.app.Activity
import android.content.Intent
import net.yuuzu.media.PermissionsController
import net.yuuzu.media.data.AppBitmap
import net.yuuzu.media.data.FileMedia
import net.yuuzu.media.data.Media

actual interface LocalMediaController {
    actual val permissionsController: PermissionsController

    actual suspend fun pickImage(source: MediaSource): AppBitmap
    actual suspend fun pickImage(source: MediaSource, maxWidth: Int, maxHeight: Int): AppBitmap
    actual suspend fun pickMedia(): Media
    actual suspend fun pickFiles(): FileMedia
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

    companion object {
        operator fun invoke(
            context: Activity
        ): LocalMediaController {
            return LocalMediaControllerImpl(
                permissionsController = PermissionsController(context),
                context = context
            )
        }
    }
}