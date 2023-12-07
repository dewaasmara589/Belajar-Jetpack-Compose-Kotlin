package com.alfastore.testjetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // To Call Composable Function
        setContent{
            ComposeNavigation()
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

@Composable
fun ComposeNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "First"){
        composable("First"){
            MainScreen(navController)
        }
        composable("Second"){
            SecondScreen(navController)
        }
    }

}


@Composable
fun MainScreen(navHostController: NavHostController){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        TextComponent("- Tes Dynamic Value 1 -", shadowColor = Color.Yellow)
//        TextComponent("- Tes Dynamic Value 2 -", shadowColor = Color.Green)

        EvenNumbers()

        Button(
            onClick = {
                navHostController.navigate("second")
            },
            modifier = Modifier.padding(top = 20.dp))
        {
            Text(text = "Next Activity", fontSize = 20.sp)
        }
    }
}


@Composable
fun EvenNumbers(){
    for (number in 2..7){
        val color = Color(
            red = Random.nextInt(256),
            green = Random.nextInt(256),
            blue = Random.nextInt(256)
        )

        TextComponent(number.toString(), color)
    }
}


// ----- START To View in Design Android Studio -----
@Composable
fun TextComponent(value: String, shadowColor: Color){

    val shadowOffset = Offset(x= 4f, y= 6f)

    Text(
        // Style Frame
        modifier = Modifier
            // Static Layout
//            .width(400.dp)
            .height(170.dp)
            // Parent Layout
            .fillMaxWidth()
//            .fillMaxHeight()
            // Padding All
//            .padding(18.dp)
            // Padding Only
//            .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp)
            // Padding Geometry
            .background(Color.LightGray)
            .padding(horizontal = 18.dp, vertical = 28.dp)
        ,

//        text = stringResource(id = R.string.welcome_message),
        text = "${stringResource(id = R.string.welcome_message)} $value",
        // Style Text
//        color = Color.Red,
//        fontStyle = FontStyle.Italic,
        style = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            shadow = Shadow(shadowColor, shadowOffset, 2f)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun defaultPreview(){
    val navController = rememberNavController()
    MainScreen(navController)
}
// ----- END To View in Design Android Studio -----
