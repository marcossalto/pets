package com.marcossalto.pets.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marcossalto.pets.domain.model.Pet

@Database(entities = [Pet::class], version = 1, exportSchema = false)
abstract class PetDB: RoomDatabase() {
    abstract fun petDao(): PetDao
}
