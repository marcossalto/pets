package com.marcossalto.pets.data.repository

import com.marcossalto.pets.data.network.PetDao
import com.marcossalto.pets.domain.model.Pet
import com.marcossalto.pets.domain.repository.PetRepository
import com.marcossalto.pets.domain.repository.Pets
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(
    private val petDao: PetDao
) : PetRepository {
    override fun getPetsFromRoom(): Flow<Pets> = petDao.getPets()

    override fun addPetToRoom(pet: Pet) = petDao.addPet(pet)

    override fun getPetFromRoom(id: Int): Pet = petDao.getPet(id)

    override fun updatePetFromRoom(pet: Pet) = petDao.updatePet(pet)

    override fun deletePetFromRoom(pet: Pet) = petDao.deletePet(pet)
}
