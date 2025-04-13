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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val artworks = remember {
        listOf(
            ArtworkItem(
                picture = R.drawable.surrealismo,
                title = R.string.surrealismo_nome,
                autor = R.string.surrealismo_autor,
                data = R.string.surrealismo_data
            ),
            ArtworkItem(
                picture = R.drawable.realista,
                title = R.string.realista_nome,
                autor = R.string.realista_autor,
                data = R.string.realista_data
            ),
            ArtworkItem(
                picture = R.drawable.desenho,
                title = R.string.desenho_nome,
                autor = R.string.desenho_autor,
                data = R.string.desenho_data
            )
        )
    }

    var index: Int by remember{ mutableIntStateOf(0) }



    val image: Painter = painterResource(artworks[index].picture)
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
                        text = stringResource(artworks[index].title),
                        modifier = modifier.fillMaxWidth(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Light,
                    )
                }
                Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text =  stringResource(artworks.get(index).autor),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Black,
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = String.format("(%s)",stringResource(artworks[index].data)),
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
            Button(onClick = {index = (index + 1 + artworks.size)%artworks.size}){
                Text(
                    text = stringResource(R.string.previous_button),
                    fontSize = 15.sp,
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {index = (index - 1 + artworks.size)%artworks.size}){
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