package com.example.personal_financial_manager.di

import android.content.Context
import androidx.room.Room
import com.example.personal_financial_manager.data.local.dao.BudgetingDao
import com.example.personal_financial_manager.data.local.dao.ExpensesDao
import com.example.personal_financial_manager.data.local.dao.IncomeDao
import com.example.personal_financial_manager.data.local.db.FinancialDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): FinancialDatabase {
        return Room.databaseBuilder(
            appContext,
            FinancialDatabase::class.java,
            "FinancialAppDb"
        ).build()
    }

    @Provides
    fun provideExpensesDao(financialDatabase: FinancialDatabase): ExpensesDao {
        return financialDatabase.expensesDao()
    }

    @Provides
    fun provideBudgetingDao(financialDatabase: FinancialDatabase): BudgetingDao {
        return financialDatabase.budgetingDao()
    }

    @Provides
    fun provideIncomeDao(financialDatabase: FinancialDatabase): IncomeDao {
        return financialDatabase.incomeDao()
    }
}