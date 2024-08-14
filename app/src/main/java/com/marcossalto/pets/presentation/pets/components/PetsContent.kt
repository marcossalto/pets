package com.marcossalto.pets.presentation.pets.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.marcossalto.pets.domain.model.Pet
import com.marcossalto.pets.domain.repository.Pets

@Composable
fun PetsContent(
    padding: PaddingValues,
    pets: Pets,
    deletePet: (pet: Pet) -> Unit,
    navigateToUpdatePetScreen: (petId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
    ) {
        items(pets) { pet ->
            PetCard(
                pet = pet,
                deletePet = { deletePet(pet) },
                navigateToUpdatePetScreen = { navigateToUpdatePetScreen(pet.id) }
            )
        }
    }
}
