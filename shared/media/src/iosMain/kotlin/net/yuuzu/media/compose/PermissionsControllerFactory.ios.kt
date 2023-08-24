package net.yuuzu.media.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import net.yuuzu.media.ios.PermissionsController

@Composable
actual fun rememberPermissionsControllerFactory(): PermissionsControllerFactory {
    return remember {
        PermissionsControllerFactory {
            PermissionsController()
        }
    }
}
