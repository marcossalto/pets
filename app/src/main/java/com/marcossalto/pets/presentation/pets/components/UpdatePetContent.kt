package com.marcossalto.pets.presentation.pets.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marcossalto.pets.R
import com.marcossalto.pets.domain.model.Pet

@Composable
fun UpdatePetContent(
    padding: PaddingValues,
    pet: Pet,
    updateAnimal: (animal: String) -> Unit,
    updateBreed: (breed: String) -> Unit,
    updatePet: (pet: Pet) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = pet.animal,
            onValueChange = { animal ->
                updateAnimal(animal)
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.animal)
                )
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = pet.breed,
            onValueChange = { breed ->
                updateBreed(breed)
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.breed)
                )
            }
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Button(
            onClick = {
                updatePet(pet)
                navigateBack()
            }
        ) {
            Text(
                text = stringResource(id = R.string.update)
            )
        }
    }
}
