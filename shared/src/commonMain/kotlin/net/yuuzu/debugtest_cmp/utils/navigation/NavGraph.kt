package net.yuuzu.debugtest_cmp.utils.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import net.yuuzu.debugtest_cmp.presentation.detail.DetailScreen
import net.yuuzu.debugtest_cmp.presentation.login.LoginScreen
import net.yuuzu.debugtest_cmp.presentation.main.MainScreen

@Composable
fun Navigation(navigator: Navigator) {
    NavHost(
        navigator = navigator,
        initialRoute = Screen.LoginScreen.route,
    ) {
        scene(route = Screen.LoginScreen.route) {
            LoginScreen(navigator)
        }
        scene(route = Screen.MainScreen.route) {
            MainScreen(navigator)
        }
        scene(route = Screen.DetailScreen.route.plus(Screen.DetailScreen.objectPath)) { backStackEntry ->
            Screen.DetailScreen.objectName?.let { objectName ->
                val projectId: String? = backStackEntry.path<String>(objectName)
                projectId?.let {
                    DetailScreen(navigator, it)
                }
            }
        }
    }
}

@Composable
fun currentRoute(navigator: Navigator): String? {
    return navigator.currentEntry.collectAsState(null).value?.route?.route
}