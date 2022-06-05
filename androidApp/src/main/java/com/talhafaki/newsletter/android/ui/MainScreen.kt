package com.talhafaki.newsletter.android.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.talhafaki.newsletter.domain.model.Article

/**
 * Created by talhafaki on 5.06.2022.
 */

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val state = viewModel.getTopHeadlines().observeAsState()
    MainContent(newsList = state.value?.articles)
}

@Composable
fun MainContent(newsList: List<Article>?) {
    LazyColumn {
        newsList?.let {
            items(it.size) { item ->
                NewsItem(article = newsList[item])
            }
        }
    }
}

@Composable
fun NewsItem(article: Article) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .border(border = BorderStroke(width = 1.dp, color = Color.LightGray), shape = RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberCoilPainter(article.urlToImage),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(100.dp)
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = article.author.orEmpty(),
                style = MaterialTheme.typography.body2.copy(
                    color = Color.Black,
                    fontSize = 20.sp
                )
            )
            Text(
                text = article.description.orEmpty(),
                style = MaterialTheme.typography.body1.copy(
                    color = Color.Black,
                    fontSize = 14.sp
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}