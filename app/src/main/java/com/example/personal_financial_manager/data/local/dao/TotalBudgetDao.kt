package com.example.personal_financial_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personal_financial_manager.data.local.entity.TotalBudgetEntity

@Dao
interface TotalBudgetDao {

    @Insert
    suspend fun insertBudget(totalBudgetEntity: TotalBudgetEntity)

    @Query("Select * from totalbudgetentity Where Year = :year And Month = :month")
    suspend fun hasTotalBudgetForSpecificDate(year: Int, month: Int): TotalBudgetEntity?
}