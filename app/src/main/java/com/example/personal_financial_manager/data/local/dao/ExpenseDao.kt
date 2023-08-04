package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.personal_financial_manager.data.local.entity.Expense

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expense")
    suspend fun fetchExpenses(): List<Expense>

    @Insert
    suspend fun insertExpenses(expense: Expense): Long

    @Update
    suspend fun updateExpense(expense: Expense): Long

    @Delete
    suspend fun deleteExpense(expense: Expense): Long

    @Query("DELETE FROM expense")
    suspend fun deleteAllExpenses(): Long
//
//    @Query("Select * from expenses where date >= :startTimeStamp and date < :endTimeStamp ")
//    suspend fun getExpensesOfSpecificDate(startTimeStamp: Long, endTimeStamp: Long)
}