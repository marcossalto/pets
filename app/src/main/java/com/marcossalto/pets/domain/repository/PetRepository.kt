package com.marcossalto.pets.domain.repository

import com.marcossalto.pets.domain.model.Pet
import kotlinx.coroutines.flow.Flow

typealias Pets = List<Pet>
interface PetRepository {
    fun getPetsFromRoom(): Flow<Pets>
    fun addPetToRoom(pet: Pet)
    fun getPetFromRoom(id: String): Flow<Pet>
    fun updatePetFromRoom(pet: Pet)
    fun deletePetFromRoom(pet: Pet)
}
