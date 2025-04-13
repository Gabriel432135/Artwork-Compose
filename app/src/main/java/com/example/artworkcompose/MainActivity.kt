package com.example.artworkcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artworkcompose.ui.theme.ArtworkComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtworkComposeTheme {
                LayoutWithBackground()
            }
        }
    }
}

@Composable
fun LayoutWithBackground(){
    Surface(modifier = Modifier){
        Box(modifier = Modifier.padding(10.dp)) {
            DisplayArtworkLayout()
        }
    }
}

@Composable
fun DisplayArtworkLayout(modifier: Modifier = Modifier) {
    var image: Painter = painterResource(R.drawable.surrealismo)
    Column(modifier = Modifier.padding(10.dp, 10.dp).fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center){
        Surface (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 10.dp), shadowElevation = 10.dp) {
            Image(modifier = Modifier.fillMaxWidth(), painter = image, contentDescription = "")
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Surface(modifier = Modifier) {
            Column(modifier = Modifier) {
                Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Artwork Title",
                        modifier = modifier.fillMaxWidth(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Light,
                    )
                }
                Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Autor",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Black,
                    )
                    Text(
                        text = "(Data)",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light,
                    )

                }
            }
        }
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            )
        {
            Button(onClick = {}){
                Text(
                    text = stringResource(R.string.previous_button),
                    fontSize = 15.sp,
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {}){
                Text(
                    text = stringResource(R.string.next_button),
                    fontSize = 15.sp,
                )
            }
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