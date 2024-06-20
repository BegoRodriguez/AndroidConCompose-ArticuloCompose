package com.example.artculodecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artculodecompose.ui.theme.ArtículoDeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtículoDeComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticleImage(
                        title = stringResource(R.string.article_title),
                        intro = stringResource(R.string.article_intro),
                        article = stringResource(R.string.article_text),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun ArticleImage(title: String, intro: String, article: String,modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier){
        Image(
            painter = image,
            contentDescription = "Header", // No agregamos descripción de contenido por ser decorativo
            contentScale = ContentScale.FillWidth, // ajusta la escala de la imagen de manera uniforme para mantener la relación de aspecto

        )
        ArticleText(
            title = title,
            intro = intro,
            article = article,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun ArticleText(title: String, intro: String, article: String,modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Top, modifier = modifier) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp),

        )
        Text(
            text = intro,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp,0.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = article,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtículoDeComposeTheme {
        ArticleImage(
            title = stringResource(R.string.article_title),
            intro = stringResource(R.string.article_intro),
            article = stringResource(R.string.article_text),
        )
    }
}