package com.example.navapp

import android.os.Parcelable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.parcelize.Parcelize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(detailsModel: DetailsModel) {
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = detailsModel.text, fontSize = 25.sp , color = Color.Red)
            Spacer(modifier = Modifier.height(50.dp))

        }
    }

}

@Parcelize
data class DetailsModel(
    val text: String
) : Parcelable