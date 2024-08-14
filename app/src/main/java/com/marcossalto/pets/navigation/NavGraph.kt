package com.marcossalto.pets.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcossalto.pets.navigation.Screen.*

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = PetsScreen.route
    ) {
        composable(route = PetsScreen.route) {
            PetsScreen(navController = navController)
        }
        composable(route = AddPetScreen.route) {
            AddPetScreen(navController = navController)
        }
        composable(route = UpdatePetScreen.route) {
            UpdatePetScreen(navController = navController)
        }
    }
}
