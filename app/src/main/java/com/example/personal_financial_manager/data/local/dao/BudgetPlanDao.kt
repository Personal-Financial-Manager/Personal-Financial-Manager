package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.personal_financial_manager.data.local.entity.BudgetPlanEntity
import com.example.personal_financial_manager.data.local.entity.TotalBudgetEntity

@Dao
interface BudgetPlanDao {

    @Insert
    suspend fun insertBudget(budgetPlanEntity: BudgetPlanEntity)
}