package net.yuuzu.debugtest_cmp.presentation.detail

import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import net.yuuzu.media.Permission
import net.yuuzu.media.PermissionState
import net.yuuzu.media.data.AppBitmap
import net.yuuzu.media.picker.LocalMediaController
import net.yuuzu.media.picker.MediaSource

class DetailViewModel(
    private val mediaController: LocalMediaController
): ViewModel() {
    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState> = _state.asStateFlow()

    fun cameraClicked() {
        viewModelScope.launch {
            try {
                mediaController.permissionsController.providePermission(Permission.CAMERA)
            } catch (e: Exception) {
                Napier.e(e.message ?: "")
            }
            when (mediaController.permissionsController.getPermissionState(Permission.CAMERA)) {
                PermissionState.NotDetermined -> {
                    Napier.e("NotDetermined")
                }
                PermissionState.Granted -> {
                    try {
                        val image = mediaController.pickImage(MediaSource.CAMERA)
                        _state.update { it.copy(
                            bitmap = image
                        ) }
                    } catch (e: Exception) {
                        Napier.e { e.message ?: "" }
                    }
                }
                PermissionState.Denied -> {
                    Napier.e("Denied")
                }
                PermissionState.DeniedAlways -> {
                    mediaController.permissionsController.openAppSettings()
                }
            }
        }
    }
}

data class DetailState(
    val bitmap: AppBitmap? = null,
)