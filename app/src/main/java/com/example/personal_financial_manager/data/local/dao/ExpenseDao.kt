package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personal_financial_manager.data.local.entity.Expense

@Dao
interface ExpenseDao {

    @Query("Select * from expense")
    suspend fun getAllExpenses():List<Expense>

    @Insert
    suspend fun insertExpenses(expense: Expense)
//
//    @Query("Select * from expenses where date >= :startTimeStamp and date < :endTimeStamp ")
//    suspend fun getExpensesOfSpecificDate(startTimeStamp: Long, endTimeStamp: Long)
}