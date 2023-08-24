package net.yuuzu.debugtest_cmp.utils.theme

import androidx.compose.runtime.Composable

@Composable
expect fun DebugTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
)