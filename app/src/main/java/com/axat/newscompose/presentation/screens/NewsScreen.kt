package com.axat.newscompose.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.axat.newscompose.domain.model.Article
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun NewsScreen(navigator: DestinationsNavigator, article: Article) {

    Column() {

        Image(
            painter = rememberAsyncImagePainter(model = article.urlToImage), contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = article.title, style = TextStyle(color = Color.Gray,
                fontWeight = FontWeight.SemiBold, fontSize = 20.sp
            ),
            modifier = Modifier.padding(12.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = article.content, style = TextStyle(color = Color.Gray,
                fontWeight = FontWeight.SemiBold, fontSize = 14.sp
            ),
            modifier = Modifier.padding(12.dp)
        )

    }

}