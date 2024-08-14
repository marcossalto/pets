package com.marcossalto.pets.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcossalto.pets.navigation.Screen.*
import com.marcossalto.pets.presentation.pets.PetsScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = PetsScreen.route
    ) {
        composable(route = PetsScreen.route) {
            PetsScreen()
        }
        composable(route = AddPetScreen.route) {
            // TODO AddPetScreen()
        }
        composable(route = UpdatePetScreen.route) {
            // TODO UpdatePetScreen()
        }
    }
}
