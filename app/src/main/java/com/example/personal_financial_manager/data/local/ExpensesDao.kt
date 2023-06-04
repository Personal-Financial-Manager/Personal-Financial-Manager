package com.example.personal_financial_manager.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpensesDao {

    @Query("Select * from expenses")
    suspend fun getAllExpenses()

    @Insert
    suspend fun insertExpenses(expenses: Expenses)

    @Query("Select * from expenses where date >= :startTimeStamp and date < :endTimeStamp ")
    suspend fun getExpensesOfSpecificDate(startTimeStamp: Long, endTimeStamp: Long)
}