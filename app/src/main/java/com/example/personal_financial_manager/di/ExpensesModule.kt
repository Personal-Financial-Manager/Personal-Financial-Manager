package com.example.personal_financial_manager.di

import com.example.personal_financial_manager.data.ExpensesRepository
import com.example.personal_financial_manager.data.ExpensesRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ExpensesModule {

    @Provides
    fun provideExpensesRepository(): ExpensesRepository {
        return ExpensesRepositoryImp()
    }
}