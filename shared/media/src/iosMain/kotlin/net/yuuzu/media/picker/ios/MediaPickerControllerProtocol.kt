package net.yuuzu.media.picker.ios

import net.yuuzu.media.PermissionsController
import net.yuuzu.media.data.AppBitmap
import net.yuuzu.media.data.FileMedia
import net.yuuzu.media.data.Media
import net.yuuzu.media.picker.MediaSource
import platform.UIKit.UIViewController

interface MediaPickerControllerProtocol {
    val permissionsController: PermissionsController

    fun bind(viewController: UIViewController)

    suspend fun pickImage(source: MediaSource): AppBitmap
    suspend fun pickImage(source: MediaSource, maxWidth: Int, maxHeight: Int): AppBitmap
    suspend fun pickMedia(): Media
    suspend fun pickFiles(): FileMedia
}