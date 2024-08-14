package com.marcossalto.pets.navigation

sealed class Screen(val route: String) {
    data object PetsScreen : Screen("pets")
    data object UpdatePetScreen : Screen("update_pet")
}
