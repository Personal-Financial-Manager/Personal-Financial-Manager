package com.example.personal_financial_manager.di

import android.content.Context
import androidx.room.Room
import com.example.personal_financial_manager.data.local.dao.BudgetPlanDao
import com.example.personal_financial_manager.data.local.dao.TotalBudgetDao
import com.example.personal_financial_manager.data.local.dao.ExpenseDao
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
    @Singleton
    fun provideExpensesDao(financialDatabase: FinancialDatabase): ExpenseDao {
        return financialDatabase.expenseDao()
    }

    @Provides
    @Singleton
    fun provideTotalBudgetDao(financialDatabase: FinancialDatabase): TotalBudgetDao {
        return financialDatabase.totalBudgetDao()
    }

    @Provides
    @Singleton
    fun provideIncomeDao(financialDatabase: FinancialDatabase): IncomeDao {
        return financialDatabase.incomeDao()
    }

    @Provides
    @Singleton
    fun provideBudgetPlanDao(financialDatabase: FinancialDatabase): BudgetPlanDao {
        return financialDatabase.budgetPlanDao()
    }
}