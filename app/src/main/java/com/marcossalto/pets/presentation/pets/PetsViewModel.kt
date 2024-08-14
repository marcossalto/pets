package com.marcossalto.pets.presentation.pets

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcossalto.pets.domain.model.Pet
import com.marcossalto.pets.domain.repository.PetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetsViewModel @Inject constructor(
    private val petRepository: PetRepository
) : ViewModel() {
    var openDialog by mutableStateOf(false)
    val pets = petRepository.getPetsFromRoom()

    fun addPet(pet: Pet) = viewModelScope.launch(Dispatchers.IO) {
        petRepository.addPetToRoom(pet)
    }

    fun updatePet(pet: Pet) = viewModelScope.launch(Dispatchers.IO) {
        petRepository.updatePetFromRoom(pet)
    }

    fun deletePet(id: String) = viewModelScope.launch(Dispatchers.IO) {
        petRepository.deletePetFromRoom(id)
    }

    fun getPet(id: String) = viewModelScope.launch(Dispatchers.IO) {
        petRepository.getPetFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

}