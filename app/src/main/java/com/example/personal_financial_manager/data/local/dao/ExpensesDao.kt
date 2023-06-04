package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personal_financial_manager.data.local.entity.Expenses

@Dao
interface ExpensesDao {

    @Query("Select * from expenses")
    suspend fun getAllExpenses():List<Expenses>

    @Insert
    suspend fun insertExpenses(expenses: Expenses)
//
//    @Query("Select * from expenses where date >= :startTimeStamp and date < :endTimeStamp ")
//    suspend fun getExpensesOfSpecificDate(startTimeStamp: Long, endTimeStamp: Long)
}