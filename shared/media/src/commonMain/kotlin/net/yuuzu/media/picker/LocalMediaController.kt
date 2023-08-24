package net.yuuzu.media.picker

import net.yuuzu.media.PermissionsController
import net.yuuzu.media.data.AppBitmap
import net.yuuzu.media.data.FileMedia
import net.yuuzu.media.data.Media

internal const val DEFAULT_MAX_IMAGE_WIDTH = 1024
internal const val DEFAULT_MAX_IMAGE_HEIGHT = 1024
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect interface LocalMediaController {
    val permissionsController: PermissionsController

    suspend fun pickImage(source: MediaSource): AppBitmap
    suspend fun pickImage(source: MediaSource, maxWidth: Int, maxHeight: Int): AppBitmap
    suspend fun pickMedia(): Media
    suspend fun pickFiles(): FileMedia
}