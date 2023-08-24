package net.yuuzu.debugtest_cmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.rememberNavigator
import net.yuuzu.debugtest_cmp.utils.LocalExMediaController
import net.yuuzu.debugtest_cmp.utils.navigation.Navigation
import net.yuuzu.debugtest_cmp.utils.theme.DebugTheme
import net.yuuzu.media.picker.LocalMediaController

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    localMediaController: LocalMediaController,
) {
    val navigator = rememberNavigator()

    CompositionLocalProvider(
        LocalExMediaController provides localMediaController,
    ) {
        DebugTheme(
            darkTheme = darkTheme,
            dynamicColor = dynamicColor,
        ) {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize()
            ) {
                Navigation(navigator)
            }
        }
    }
}