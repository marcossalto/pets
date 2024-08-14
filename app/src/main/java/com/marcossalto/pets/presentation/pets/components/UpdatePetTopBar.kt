package com.marcossalto.pets.presentation.pets.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.marcossalto.pets.R

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
