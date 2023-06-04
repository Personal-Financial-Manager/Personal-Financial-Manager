package com.example.personal_financial_manager.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.personal_financial_manager.data.local.dao.BudgetDao
import com.example.personal_financial_manager.data.local.entity.Expense
import com.example.personal_financial_manager.data.local.dao.ExpenseDao
import com.example.personal_financial_manager.data.local.dao.IncomeDao
import com.example.personal_financial_manager.data.local.entity.Budget
import com.example.personal_financial_manager.data.local.entity.Income

@Database(entities = [Expense::class, Income::class, Budget::class], version = 1)
abstract class FinancialDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    abstract fun budgetDao(): BudgetDao
    abstract fun incomeDao(): IncomeDao
}