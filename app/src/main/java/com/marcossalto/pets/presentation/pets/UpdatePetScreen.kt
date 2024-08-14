package com.marcossalto.pets.presentation.pets

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcossalto.pets.presentation.pets.components.UpdatePetContent
import com.marcossalto.pets.presentation.pets.components.UpdatePetTopBar

@Composable
fun UpdatePetScreen(
    viewModel: PetsViewModel = hiltViewModel(),
    petId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getPet(petId)
    }
    Scaffold(
        topBar = {
            UpdatePetTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdatePetContent(
                padding = padding,
                pet = viewModel.pet,
                updateAnimal = { animal ->
                    viewModel.updateAnimal(animal)
                },
                updateBreed = { breed ->
                    viewModel.updateBreed(breed)
                },
                updatePet = { pet ->
                    viewModel.updatePet(pet)
                },
                navigateBack = navigateBack
            )
        }
    )
}
