package com.example.playground.presentation.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.playground.R
import com.example.playground.core.ResponseStatus
import com.example.playground.core.extensions.paddingValues
import com.example.playground.core.extensions.toCustomDateFormat
import com.example.playground.presentation.viewmodels.MainScreenViewModel

@Composable
fun MainScreen() {
    val mainScreenViewModel: MainScreenViewModel = viewModel()

    val isCardExpanded = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        mainScreenViewModel.fetchColors()
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            ObserveData(
                mainScreenViewModel = mainScreenViewModel,
                isCardExpanded = isCardExpanded
            )
        }
    }
}


@Composable
fun ObserveData(
    mainScreenViewModel: MainScreenViewModel,
    isCardExpanded: MutableState<Boolean>,
) {

    val colorsState by mainScreenViewModel.colors.collectAsState()
    when (colorsState) {
        is ResponseStatus.Success -> {
            val colorsData = (colorsState as ResponseStatus.Success).data

            if (isCardExpanded.value) {
                colorsData.forEach {
                    SingleItemCard(
                        badge = it.badgeUrl,
                        title = it.title,
                        author = it.userName,
                        rgbName = it.rgb.toString(),
                        dateCreated = it.dateCreated.toCustomDateFormat(),
                        rank = it.rank.toString(),
                        isCardExpanded = isCardExpanded
                    )
                }

            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(colorsData) { color ->
                        SingleItemCard(
                            badge = color.badgeUrl,
                            title = color.title,
                            author = color.userName,
                            rgbName = null,
                            dateCreated = null,
                            rank = null,
                            isCardExpanded = isCardExpanded
                        )
                    }
                }
            }
        }

        is ResponseStatus.Fail -> {
            Text(text = "Error: ${(colorsState as ResponseStatus.Fail).message}")
        }

        ResponseStatus.Loading -> {
            Log.d("loader", "loading")
        }
    }
}


@Composable
fun SingleItemCard(
    badge: String,
    title: String?,
    author: String?,
    rgbName: String?,
    dateCreated: String?,
    rank: String?,
    isCardExpanded: MutableState<Boolean>,
) {
    Column(
        modifier = Modifier
            .width(if (isCardExpanded.value) 600.dp else 300.dp)
            .height(if (isCardExpanded.value) 700.dp else 400.dp)
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clickable {
                isCardExpanded.value = !isCardExpanded.value
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(badge)
                .crossfade(true).build(),
            contentDescription = "Logo",
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )

        title?.let {
            Text(
                text = it,
                modifier = Modifier.paddingValues()
            )
        }
        author?.let {
            Text(
                text = it,
                modifier = Modifier.paddingValues()
            )
        }

        dateCreated?.let {
            Text(
                text = it,
                modifier = Modifier.paddingValues()
            )
        }

        rgbName?.let {
            Text(
                text = it,
                modifier = Modifier.paddingValues()
            )
        }
        rank?.let {
            Text(
                text = it,
                modifier = Modifier.paddingValues()
            )
        }
    }
}