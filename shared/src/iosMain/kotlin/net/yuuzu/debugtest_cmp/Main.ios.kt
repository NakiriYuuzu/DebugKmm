package net.yuuzu.debugtest_cmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import moe.tlaster.precompose.PreComposeApplication
import net.yuuzu.media.ios.PermissionsController
import net.yuuzu.media.picker.ios.MediaPickerController
import platform.UIKit.UIApplication
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle
import platform.UIKit.UIViewController

@Composable
internal fun MainView() {
    val window = UIApplication.sharedApplication.keyWindow
    val viewController = window?.rootViewController
    val permissionsController by remember {
        mutableStateOf(
            MediaPickerController(
                PermissionsController()
            )
        )
    }
    val isDarkTheme = UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
            UIUserInterfaceStyle.UIUserInterfaceStyleDark

    LaunchedEffect(Unit) {
        if (viewController != null) permissionsController.bind(viewController = viewController)
    }

    App(
        darkTheme = isDarkTheme,
        dynamicColor = false,
        localMediaController = permissionsController
    )
}

fun MainViewController(): UIViewController {
    return PreComposeApplication {
        MainView()
    }
}