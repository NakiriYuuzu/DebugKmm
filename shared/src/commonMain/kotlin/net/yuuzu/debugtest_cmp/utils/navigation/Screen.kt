package net.yuuzu.debugtest_cmp.utils.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String? = null,
    val navIcon: ImageVector? = null,
    val objectName: String? = null,
    val objectPath: String? = null
) {
    object LoginScreen : Screen(
        route = "login_screen",
        title = "Login"
    )
    object MainScreen : Screen(
        route = "main_screen",
        title = "Main"
    )
    object DetailScreen : Screen(
        route = "detail_screen",
        title = "Detail",
        objectName = "projectId",
        objectPath = "/{projectId}"
    )
}