package com.example.personal_financial_manager.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(FragmentComponent::class)
@Module
class CalendarModule {

//    @Provides
//    @Singleton
//    fun providePersianDate(@ApplicationContext appContext: Context): PersianDate {
//        return PersianDate();
//    }
}