package com.marcossalto.pets.presentation.pets.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marcossalto.pets.R
import com.marcossalto.pets.domain.model.Pet
import kotlinx.coroutines.job

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
                                text = stringResource(id = R.string.you_have_a)
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
