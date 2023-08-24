package net.yuuzu.media.picker

import android.app.Activity
import android.content.Intent
import net.yuuzu.media.Permission
import net.yuuzu.media.data.AppBitmap
import net.yuuzu.media.PermissionsController
import net.yuuzu.media.data.FileMedia
import net.yuuzu.media.data.Media
import kotlin.coroutines.suspendCoroutine

internal class LocalMediaControllerImpl(
    override val permissionsController: PermissionsController,
    context: Activity
) : LocalMediaController {
    private val imagePicker = ImagePicker(context)
    private val mediaPicker = MediaPicker(context)
    private var pickerType = PickerType.MEDIA

    override suspend fun pickImage(source: MediaSource): AppBitmap {
        pickerType = PickerType.IMAGE
        return pickImage(source, DEFAULT_MAX_IMAGE_WIDTH, DEFAULT_MAX_IMAGE_HEIGHT)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (pickerType) {
            PickerType.MEDIA -> mediaPicker.onActivityResult(requestCode, resultCode, data)
            PickerType.IMAGE -> imagePicker.onActivityResult(requestCode, resultCode, data)
        }
    }

    /**
     * A default values for [maxWidth] and [maxHeight] arguments are not used because bug of kotlin
     * compiler. Default values for suspend functions don't work correctly.
     * (Look here: https://youtrack.jetbrains.com/issue/KT-37331)
     */
    override suspend fun pickImage(source: MediaSource, maxWidth: Int, maxHeight: Int): AppBitmap {
        source.requiredPermissions().forEach { permission ->
            permissionsController.providePermission(permission)
        }

        val bitmap = suspendCoroutine { continuation ->
            val action: (Result<android.graphics.Bitmap>) -> Unit = { continuation.resumeWith(it) }
            when (source) {
                MediaSource.GALLERY -> imagePicker.pickGalleryImage(action)
                MediaSource.CAMERA -> imagePicker.pickCameraImage(action)
            }
        }

        return AppBitmap(bitmap)
    }

    override suspend fun pickMedia(): Media {
        pickerType = PickerType.MEDIA
        permissionsController.providePermission(Permission.GALLERY)


        return suspendCoroutine { continuation ->
            val action: (Result<Media>) -> Unit = { continuation.resumeWith(it) }
            mediaPicker.pickMedia(action)
        }
    }

    override suspend fun pickFiles(): FileMedia {
        /*val fragmentManager =
            fragmentManager ?: error("can't pick image without active window")

        permissionsController.providePermission(Permission.STORAGE)

        val currentFragment: Fragment? = fragmentManager.findFragmentByTag(filePickerFragmentTag)
        val pickerFragment: FilePickerFragment = if (currentFragment != null) {
            currentFragment as FilePickerFragment
        } else {
            FilePickerFragment().apply {
                fragmentManager
                    .beginTransaction()
                    .add(this, pickerFragmentTag)
                    .commitNow()
            }
        }

        val path = suspendCoroutine<FileMedia> { continuation ->
            val action: (Result<FileMedia>) -> Unit = { continuation.resumeWith(it) }
            pickerFragment.pickFile(action)
        }*/

        return FileMedia(name = "", path = "")
    }

    private fun MediaSource.requiredPermissions(): List<Permission> {
        return when (this) {
            MediaSource.GALLERY -> listOf(Permission.GALLERY)
            MediaSource.CAMERA -> listOf(Permission.CAMERA)
        }
    }

    enum class PickerType {
        IMAGE,
        MEDIA
    }
}