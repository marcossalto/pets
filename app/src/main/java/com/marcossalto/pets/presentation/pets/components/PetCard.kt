package com.marcossalto.pets.presentation.pets.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marcossalto.pets.domain.model.Pet

@Composable
fun PetCard(
    pet: Pet,
    deletePet: () -> Unit,
    navigateToUpdatePetScreen: (petId: Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        onClick = { navigateToUpdatePetScreen(pet.id) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = CenterVertically
        ) {
            Column {
                Text(
                    text = pet.animal,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = pet.breed,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            DeleteIcon(
                deletePet = deletePet
            )
        }
    }
}
