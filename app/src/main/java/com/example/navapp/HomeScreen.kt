package com.example.navapp

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController : NavController) {

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello World")
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {
                val detailsModel = DetailsModel(text = "Hello World")
                val detailsAsJsonString = Uri.encode(Gson().toJson(detailsModel))
                navController.navigate("details/$detailsAsJsonString")
            }) {
                Text(text = "Navigate")
            }
        }
    }
}