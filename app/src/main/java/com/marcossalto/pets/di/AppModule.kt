package com.marcossalto.pets.di

import android.content.Context
import androidx.room.Room
import com.marcossalto.pets.core.Constants.Companion.DATABASE_NAME
import com.marcossalto.pets.data.network.PetDB
import com.marcossalto.pets.data.network.PetDao
import com.marcossalto.pets.data.repository.PetRepositoryImpl
import com.marcossalto.pets.domain.repository.PetRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providePetDB(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        PetDB::class.java,
        DATABASE_NAME
    )
        .build()

    @Provides
    fun providePetDao(petDB: PetDB) = petDB.petDao()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPetRepository(impl: PetRepositoryImpl?): PetRepository?
}
