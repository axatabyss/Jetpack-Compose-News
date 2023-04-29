package com.axat.newscompose.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.axat.newscompose.domain.model.Article
import com.axat.newscompose.presentation.screens.destinations.NewsScreenDestination
import com.axat.newscompose.presentation.viewmodel.NewsViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator, viewModel: NewsViewModel = hiltViewModel()) {

    val res = viewModel.articles.value


    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize())
        {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }
    }


    res.data?.let {
        LazyColumn {
            items(it) {

                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = 2.dp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Column(modifier = Modifier.clickable {

                        navigator.navigate(
                            NewsScreenDestination(
                                article = Article(
                                    title = it.title,
                                    description = it.description,
                                    content = it.content,
                                    urlToImage = it.urlToImage,
                                )
                            )
                        )

                    }) {

                        Image(
                            painter = rememberAsyncImagePainter(model = it.urlToImage),
                            contentDescription = null,
                            modifier = Modifier
                                .height(300.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = it.title, style = TextStyle(
                                color = Color.Gray,
                                fontWeight = FontWeight.SemiBold, fontSize = 18.sp
                            ),
                            modifier = Modifier.padding(12.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                    }
                }

            }
        }
    }


}