package com.marcossalto.pets.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marcossalto.pets.core.Constants.Companion.PET_TABLE
import com.marcossalto.pets.domain.model.Pet
import com.marcossalto.pets.domain.repository.Pets
import kotlinx.coroutines.flow.Flow

@Dao
interface PetDao {
    @Query("SELECT * FROM $PET_TABLE ORDER BY id ASC")
    fun getPets(): Flow<Pets>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPet(pet: Pet)

    @Query("SELECT * FROM $PET_TABLE WHERE id = :id")
    fun getPet(id: Int): Pet

    @Update
    fun updatePet(pet: Pet)

    @Delete
    fun deletePet(pet: Pet)

    @Query("DELETE FROM $PET_TABLE")
    fun deleteAllPets()
}
