package com.alfastore.testjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ImageColumnRow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            secondScreen()
        }
    }
}

@Composable
fun secondScreen(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        for (count in 1..10){
            Card (modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 8.dp)
                .background(Color.LightGray)
                .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp)
            ) {
                content()
            }
        }
    }
}

@Composable
fun content(){
    Row (modifier = Modifier
        .padding(vertical = 10.dp, horizontal = 8.dp)) {
        Box(modifier = Modifier
            .size(40.dp)
            .clip(shape = CircleShape)
            .background(Color.Green)
        ){
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Contact profile picture",
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = "Name", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = "Message Text",
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewDesign(){
    secondScreen()
}