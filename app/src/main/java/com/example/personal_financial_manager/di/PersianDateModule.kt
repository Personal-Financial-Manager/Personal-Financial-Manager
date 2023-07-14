package com.example.personal_financial_manager.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import saman.zamani.persiandate.PersianDate


@InstallIn(ViewModelComponent::class)
@Module
class PersianDateModule {

    @Provides
    fun providePersianDate(): PersianDate {
        return PersianDate()
    }
}
