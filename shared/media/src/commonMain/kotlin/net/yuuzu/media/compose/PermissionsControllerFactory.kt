package net.yuuzu.media.compose

import androidx.compose.runtime.Composable
import net.yuuzu.media.PermissionsController

fun interface PermissionsControllerFactory {
    fun createPermissionsController(): PermissionsController
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
@Composable
expect fun rememberPermissionsControllerFactory(): PermissionsControllerFactory
