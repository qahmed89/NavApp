package com.example.navapp.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun NavigationBottomBar(navController: NavController) {
    val isSelected = navController.currentBackStackEntryAsState()
    val currentRoute = isSelected.value?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = isSelectedItem(currentRoute,"home"),
            onClick = { navController.navigate("home") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon"
                )
            })
        NavigationBarItem(
            selected =  isSelectedItem(currentRoute, "favorite"),
            onClick = { navController.navigate("favorite") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon"
                )
            })
        NavigationBarItem(
            selected =  isSelectedItem(currentRoute,"search"),
            onClick = { navController.navigate("search") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            })

    }
}

fun isSelectedItem (currentRoute : String?, compareRoute : String) = currentRoute == compareRoute