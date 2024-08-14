package com.marcossalto.pets.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.marcossalto.pets.core.Constants.Companion.PET_ID
import com.marcossalto.pets.navigation.Screen.*
import com.marcossalto.pets.presentation.pets.PetsScreen
import com.marcossalto.pets.presentation.pets.UpdatePetScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = PetsScreen.route
    ) {
        composable(
            route = PetsScreen.route
        ) {
            PetsScreen(
                navigateToUpdatePetScreen = {
                    petId ->
                    navController.navigate("${UpdatePetScreen.route}/$petId")
                }
            )
        }
        composable(
            route = "${UpdatePetScreen.route}/{$PET_ID}",
            arguments = listOf(
                navArgument(PET_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            UpdatePetScreen(
                petId = backStackEntry.arguments?.getInt(PET_ID) ?: 0,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
