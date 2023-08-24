package net.yuuzu.debugtest_cmp.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator
import net.yuuzu.debugtest_cmp.utils.LocalExMediaController

@Composable
fun DetailScreen(
    navigator: Navigator,
    id: String,
) {
    val mediaController = LocalExMediaController.current
    val viewModel = DetailViewModel(mediaController)
    val state by viewModel.state.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ExtendedFloatingActionButton(
            onClick = {
                viewModel.cameraClicked()
            }
        ) {
            Text(text = "Camera $id")
        }

        if (state.bitmap != null) {
            Image(
                bitmap = state.bitmap!!.toImageBitmap(),
                contentDescription = null,
            )
        }
    }
}