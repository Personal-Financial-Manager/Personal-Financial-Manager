package com.example.personal_financial_manager.di

import com.example.personal_financial_manager.data.ExpensesRepository
import com.example.personal_financial_manager.data.ExpensesRepositoryImp
import com.example.personal_financial_manager.data.local.db.FinancialDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ExpensesModule {

    @Provides
    @Singleton
    fun provideExpensesRepository(database: FinancialDatabase): ExpensesRepository {
        return ExpensesRepositoryImp(database)
    }
}