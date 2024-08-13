package com.marcossalto.pets.di

import android.content.Context
import androidx.room.Room
import com.marcossalto.pets.core.Constants.Companion.PET_TABLE
import com.marcossalto.pets.data.network.PetDB
import com.marcossalto.pets.data.network.PetDao
import com.marcossalto.pets.data.repository.PetRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providePetDB(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        PetDB::class.java,
        PET_TABLE
    )
        .build()

    @Provides
    fun providePetDao(petDB: PetDB) = petDB.petDao()

    @Provides
    fun providePetRepository(petDao: PetDao) = PetRepositoryImpl(petDao)
}
