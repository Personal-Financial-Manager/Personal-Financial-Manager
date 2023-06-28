package com.example.personal_financial_manager.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.personal_financial_manager.data.local.dao.BudgetPlanDao
import com.example.personal_financial_manager.data.local.dao.TotalBudgetDao
import com.example.personal_financial_manager.data.local.entity.Expense
import com.example.personal_financial_manager.data.local.dao.ExpenseDao
import com.example.personal_financial_manager.data.local.dao.IncomeDao
import com.example.personal_financial_manager.data.local.entity.BudgetPlanEntity
import com.example.personal_financial_manager.data.local.entity.TotalBudgetEntity
import com.example.personal_financial_manager.data.local.entity.IncomeEntity

@Database(entities = [
    Expense::class,
    IncomeEntity::class,
    TotalBudgetEntity::class,
    BudgetPlanEntity::class],
    version = 1)
abstract class FinancialDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    abstract fun totalBudgetDao(): TotalBudgetDao
    abstract fun incomeDao(): IncomeDao
    abstract fun budgetPlanDao(): BudgetPlanDao
}