package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personal_financial_manager.data.local.entity.Income

@Dao
interface IncomeDao {

    @Query("Select * from income")
    suspend fun getAllIncome():List<Income>

    @Insert
    suspend fun insertIncome(income: Income)
}