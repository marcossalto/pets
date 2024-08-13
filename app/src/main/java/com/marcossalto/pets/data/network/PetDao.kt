package com.marcossalto.pets.data.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marcossalto.pets.domain.model.Pet
import com.marcossalto.pets.domain.repository.Pets
import kotlinx.coroutines.flow.Flow

@Dao
interface PetDao {
    @Query("SELECT * FROM pet_table ORDER BY id ASC")
    fun getPets(): Flow<Pets>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPet(pet: Pet)

    @Query("SELECT * FROM pet_table WHERE id = :id")
    fun getPet(id: String): Flow<Pet>

    @Update
    fun updatePet(pet: Pet)

    @Query("DELETE FROM pet_table WHERE id = :id")
    fun deletePet(id: String)

    @Query("DELETE FROM pet_table")
    fun deleteAllPets()
}
