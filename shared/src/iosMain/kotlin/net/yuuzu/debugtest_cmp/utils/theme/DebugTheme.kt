package net.yuuzu.debugtest_cmp.utils.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun DebugTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if(darkTheme) DarkColors else LightColors,
        content = content
    )
}