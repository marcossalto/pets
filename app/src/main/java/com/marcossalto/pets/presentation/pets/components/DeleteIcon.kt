package com.marcossalto.pets.presentation.pets.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.marcossalto.pets.R

@Composable
fun DeleteIcon(
    deletePet: () -> Unit
) {
    IconButton(
        onClick = deletePet
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = stringResource(id = R.string.delete_pet_title)
        )
    }
}
