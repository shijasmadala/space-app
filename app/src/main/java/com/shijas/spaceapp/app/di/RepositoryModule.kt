package com.shijas.spaceapp.app.di

import com.shijas.spaceapp.data.repository.HomeRepositoryImpl
import com.shijas.spaceapp.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindHomeNasaDataRepository(homeRepositoryImpl: HomeRepositoryImpl) : HomeRepository


}