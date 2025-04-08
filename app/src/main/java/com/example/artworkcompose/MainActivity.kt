package com.example.artworkcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.artworkcompose.ui.theme.ArtworkComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtworkComposeTheme {
                DisplayArtworkLayout()
            }
        }
    }
}


@Composable
fun DisplayArtworkLayout(modifier: Modifier = Modifier) {
    var image: Painter = painterResource(R.drawable.surrealismo)
    Column(modifier = Modifier){
        Row(modifier = Modifier){
            Image(painter = image, contentDescription = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtworkComposeTheme {
        DisplayArtworkLayout()
    }
}