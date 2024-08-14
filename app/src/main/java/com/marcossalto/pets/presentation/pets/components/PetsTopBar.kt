package com.marcossalto.pets.presentation.pets.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.marcossalto.pets.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.pets_title)) }
    )
}
