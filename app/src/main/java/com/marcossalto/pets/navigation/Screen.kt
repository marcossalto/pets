package com.marcossalto.pets.navigation

sealed class Screen(val route: String) {
    data object PetsScreen : Screen("pets")
    data object AddPetScreen : Screen("add_pet")
    data object UpdatePetScreen : Screen("update_pet/{id}")
}
