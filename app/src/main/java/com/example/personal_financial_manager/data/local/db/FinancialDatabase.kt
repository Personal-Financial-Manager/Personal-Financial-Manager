package com.example.personal_financial_manager.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.personal_financial_manager.data.local.dao.BudgetingDao
import com.example.personal_financial_manager.data.local.entity.Expenses
import com.example.personal_financial_manager.data.local.dao.ExpensesDao
import com.example.personal_financial_manager.data.local.dao.IncomeDao
import com.example.personal_financial_manager.data.local.entity.Budgeting
import com.example.personal_financial_manager.data.local.entity.Income

@Database(entities = [Expenses::class, Income::class, Budgeting::class], version = 1)
abstract class FinancialDatabase : RoomDatabase() {
    abstract fun expensesDao(): ExpensesDao
    abstract fun budgetingDao(): BudgetingDao
    abstract fun incomeDao(): IncomeDao
}