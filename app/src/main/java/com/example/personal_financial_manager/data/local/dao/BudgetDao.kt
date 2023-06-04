package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.personal_financial_manager.data.local.entity.Budget

@Dao
interface BudgetDao {

    @Insert
    suspend fun insertBudget(budget: Budget)
}