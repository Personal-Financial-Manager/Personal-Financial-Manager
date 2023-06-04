package com.example.personal_financial_manager.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.personal_financial_manager.data.local.entity.Expenses
import com.example.personal_financial_manager.data.local.dao.ExpensesDao

@Database(entities = [Expenses::class], version = 1)
abstract class FinancialDatabase : RoomDatabase() {
    abstract fun userDao(): ExpensesDao
}