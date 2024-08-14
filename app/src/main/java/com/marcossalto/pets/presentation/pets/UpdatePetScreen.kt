package com.marcossalto.pets.presentation.pets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcossalto.pets.R
import com.marcossalto.pets.domain.model.Pet

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatePetTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.update_pet_title))
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = null
                )
            }

        }
    )
}

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
