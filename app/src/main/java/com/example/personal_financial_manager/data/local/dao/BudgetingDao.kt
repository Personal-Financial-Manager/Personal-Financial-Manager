package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.personal_financial_manager.data.local.entity.Budgeting

@Dao
interface BudgetingDao {

    @Insert
    suspend fun insertBudget(budgeting: Budgeting)
}