package net.yuuzu.debugtest_cmp.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator
import net.yuuzu.debugtest_cmp.utils.navigation.Screen

@Composable
fun LoginScreen(
    navigator: Navigator
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ExtendedFloatingActionButton(
            onClick = {
                navigator.navigate(Screen.MainScreen.route)
            }
        ) {
            Text(text = "Login")
        }
    }
}