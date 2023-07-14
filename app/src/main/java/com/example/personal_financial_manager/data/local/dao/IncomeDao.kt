package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personal_financial_manager.data.local.entity.IncomeEntity

@Dao
interface IncomeDao {

    @Query("Select * from IncomeEntity")
    suspend fun getAllIncome():List<IncomeEntity>

    @Insert
    suspend fun insertIncome(incomeEntity: IncomeEntity)
}