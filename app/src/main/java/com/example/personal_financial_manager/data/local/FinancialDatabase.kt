package com.example.personal_financial_manager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Expenses::class], version = 1)
abstract class FinancialDatabase : RoomDatabase() {
    abstract fun userDao(): ExpensesDao
}