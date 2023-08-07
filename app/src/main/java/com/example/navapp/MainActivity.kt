package com.example.navapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navapp.composable.NavigationBottomBar
import com.example.navapp.ui.theme.NavAppTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        // step 1
        // convert Data class to json String with gson
        // send that string to the rout of navigation

        // step 2
        // get that string from args
        // convert that string to Data Class with GSON
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(modifier= Modifier.fillMaxSize(), bottomBar = { NavigationBottomBar(
                    navController = navController
                )}) {


                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") {
                                HomeScreen(navController = navController){
                                    val intent = Intent(this@MainActivity,DetailsActivity::class.java)
                                    intent.putExtra("data","Android")
                                    startActivity(intent)
                                }
                            }
                            composable("favorite"){
                                FavoriteScreen()
                            }
                            composable("search"){
                                SearchScreen()
                            }

                            composable("details/{data}", arguments = listOf(
                                navArgument("data") {
                                    type = NavType.StringType
                                }
                            )) {
                                val arg = it.arguments?.getString("data")
                                val detailsModel: ListDetailsModel =
                                    Gson().fromJson(arg, ListDetailsModel::class.java)
                                DetailsScreen(detailsModel = detailsModel)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavAppTheme {
        Greeting("Android")
    }
}