package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personal_financial_manager.data.local.entity.Income

@Dao
interface IncomeDoa {

    @Query("Select * from expenses")
    suspend fun getAllIncome()

    @Insert
    suspend fun insertIncome(income: Income)
}