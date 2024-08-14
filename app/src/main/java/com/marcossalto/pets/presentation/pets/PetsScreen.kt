package com.marcossalto.pets.presentation.pets

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcossalto.pets.presentation.pets.components.AddPetDialog
import com.marcossalto.pets.presentation.pets.components.AddPetFloatingActionButton
import com.marcossalto.pets.presentation.pets.components.PetsContent
import com.marcossalto.pets.presentation.pets.components.PetsTopBar

@Composable
fun PetsScreen(
    viewModel: PetsViewModel = hiltViewModel(),
    navigateToUpdatePetScreen: (petId: Int) -> Unit
) {
    val pets by viewModel.pets.collectAsState(initial = emptyList())

    Scaffold(
        topBar = { PetsTopBar() },
        content = { padding ->
            PetsContent(
                padding = padding,
                pets = pets,
                deletePet = { pet ->
                    viewModel.deletePet(pet)
                },
                navigateToUpdatePetScreen = navigateToUpdatePetScreen
            )
            AddPetDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addPet = { pet ->
                    viewModel.addPet(pet)
                }
            )
        },
        floatingActionButton = {
            AddPetFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}
