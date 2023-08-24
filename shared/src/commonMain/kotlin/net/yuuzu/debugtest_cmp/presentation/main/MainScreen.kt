package net.yuuzu.debugtest_cmp.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator
import net.yuuzu.debugtest_cmp.utils.navigation.Screen

@Composable
fun MainScreen(
    navigator: Navigator
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(10) {
            ExtendedFloatingActionButton(
                onClick = {
                    navigator.navigate(Screen.DetailScreen.route.plus("/$it"))
                },
            ) {
                Text(text = "Detail $it")
            }
        }
    }
}