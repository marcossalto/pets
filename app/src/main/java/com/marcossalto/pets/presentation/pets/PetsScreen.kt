package com.marcossalto.pets.presentation.pets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcossalto.pets.R
import com.marcossalto.pets.domain.model.Pet
import com.marcossalto.pets.domain.repository.Pets
import kotlinx.coroutines.job

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.pets_title)) }
    )
}

@Composable
fun PetsContent(
    padding: PaddingValues,
    pets: Pets
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
    ) {
        items(pets) { pet ->
            PetCard(
                pet = pet
            )
        }
    }
}

@Composable
fun PetCard(
    pet: Pet
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
        )
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
        }
    }
}

@Composable
fun AddPetDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addPet: (pet: Pet) -> Unit
) {
    if (openDialog) {
        var animal by rememberSaveable { mutableStateOf("") }
        var breed by rememberSaveable { mutableStateOf("") }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = stringResource(id = R.string.add_pet_title)
                )
            },
            text = {
                Column {
                    TextField(
                        value = animal,
                        onValueChange = {
                            animal = it
                        },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.pet_breed)
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(
                        Unit
                    ) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = breed,
                        onValueChange = {
                            breed = it
                        },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.pet_breed)
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        addPet(
                            Pet(
                                id = 0,
                                animal = animal,
                                breed = breed
                            )
                        )
                    }) {
                    Text(text = stringResource(id = R.string.add))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(text = stringResource(id = R.string.cancel))
                }
            })
    }
}

@Composable
fun AddPetFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = openDialog
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_pet_title)
        )
    }

}

@Composable
fun PetsScreen(
    viewModel: PetsViewModel = hiltViewModel()
) {
    val pets by viewModel.pets.collectAsState(initial = emptyList())

    Scaffold(
        topBar = { PetsTopBar() },
        content = { padding ->
            PetsContent(
                padding = padding,
                pets = pets
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
