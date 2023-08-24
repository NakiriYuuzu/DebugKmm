package net.yuuzu.debugtest_cmp.utils

import androidx.compose.runtime.staticCompositionLocalOf
import net.yuuzu.media.picker.LocalMediaController

val LocalExMediaController = staticCompositionLocalOf<LocalMediaController> {
    error("Unable to get the controller")
}