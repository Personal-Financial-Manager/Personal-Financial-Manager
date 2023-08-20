package com.example.personal_financial_manager.data

import com.example.personal_financial_manager.data.local.dao.TotalBudgetDao
import com.example.personal_financial_manager.data.local.entity.TotalBudgetEntity
import com.example.personal_financial_manager.data.model.mapToTotalBudget
import javax.inject.Inject

class TotalBudgetRepository @Inject constructor(private val totalBudgetDao: TotalBudgetDao) {
    suspend fun getTotalBudgetForSpecificDate(year: Int, month: Int): TotalBudgetEntity? {
       return totalBudgetDao.hasTotalBudgetForSpecificDate(year, month)
    }

    suspend fun updateTotalBudget(totalBudgetEntity: TotalBudgetEntity){
        totalBudgetDao.insertBudget(totalBudgetEntity)
    }
}