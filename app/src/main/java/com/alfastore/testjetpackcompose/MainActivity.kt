package com.alfastore.testjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // To Call Composable Function
        setContent{
            TextComponent("- Tes Dynamic Value -")
        }
    }

    // View in run avd / emulator
//    @Composable
//    fun TextComponent(value: String) {
        // Static Value
//        Text(text = "Hello World")
        // Dinamic Value
//        val welcomeMessage = "$value ${getString(R.string.welcome_message)}"
//        Text(text = welcomeMessage)

        // Value From string.xml
//        Text(
//            text = stringResource(id = R.string.welcome_message),
//            // Style Text
//            color = Color.Blue,
//            fontSize = 28.sp,
//            fontStyle = FontStyle.Italic,
//            fontWeight = FontWeight.Bold
//        )
//    }
}



// ----- START To View in Design Android Studio -----
@Composable
fun TextComponent(value: String){
    Text(
        // Style Frame
        modifier = Modifier
            // Static Layout
//            .width(400.dp)
//            .height(100.dp)
            // Parent Layout
            .fillMaxWidth()
            .fillMaxHeight()
            // Padding All
//            .padding(18.dp)
            // Padding Only
//            .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp)
            // Padding Geometry
            .padding(horizontal = 18.dp, vertical = 28.dp)
            .background(Color.LightGray)
        ,

        text = stringResource(id = R.string.welcome_message),
        // Style Text
        color = Color.Red,
        fontSize = 28.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Medium
    )
}

@Preview(showBackground = true)
@Composable
fun defaultPreview(){
    TextComponent(value = "Test")
}
// ----- END To View in Design Android Studio -----
