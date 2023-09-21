package com.udemy.app

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udemy.app.ui.theme.UdemyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UdemyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun MyApp() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFFC0C0C0)) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(10.dp)
        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                ProfileImage()
                Divider()
                Text(style = MaterialTheme.typography.titleLarge,
                    color = Color.Blue,
                    text = "Siema")
                Text(text = "To ja")
                Text(text = "farmakeler")
                Button(onClick = { buttonClickedState.value = !buttonClickedState.value
                }) {
                    Text(text = "Portfolio")
                }
                if (buttonClickedState.value){
                    Content()
                }
                else{
                    Box(){}
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ){
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }

}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){
            item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                ) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface))
                {
                    ProfileImage()
                    Text(text = "Siema")
                }
            }
        }
    }
}

@Composable
fun ProfileImage(){
    Surface(modifier = Modifier
        .size(200.dp)
        .padding(20.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color(0xFF3A6EA5)),
        color = MaterialTheme.colorScheme.background.copy(alpha = 0.6f)
    ) {
        Image(painter = painterResource(id = R.drawable.id),
            contentDescription = "Siema",
            contentScale = ContentScale.Crop)
    }
}