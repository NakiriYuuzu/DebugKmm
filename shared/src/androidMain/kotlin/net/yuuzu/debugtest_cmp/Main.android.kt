package net.yuuzu.debugtest_cmp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import net.yuuzu.media.picker.LocalMediaController

@Composable
fun MainView(localMediaController: LocalMediaController) {
    App(
        darkTheme = isSystemInDarkTheme(),
        dynamicColor = false,
        localMediaController = localMediaController
    )
}