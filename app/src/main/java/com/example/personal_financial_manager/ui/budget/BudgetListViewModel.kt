package com.example.personal_financial_manager.ui.budget

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personal_financial_manager.data.BudgetPlanRepository
import com.example.personal_financial_manager.usecase.budget.TotalBudgetUseCase
import com.example.personal_financial_manager.util.CalendarHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BudgetListViewModel(private val totalBudgetUseCase: TotalBudgetUseCase) : ViewModel() {

    @Inject
    lateinit var budgetPlanRepository: BudgetPlanRepository

    @Inject
    lateinit var calendarHelper: CalendarHelper

    var _budgetInfoUiState = MutableLiveData<BudgetInfo>()
    var budgetInfoUiState: LiveData<BudgetInfo> = _budgetInfoUiState

    init {
        isUserSetBudget()
    }

    private fun isUserSetBudget() {
        viewModelScope.launch {
            val currentDateTime = calendarHelper.getCurrentDateTime()
            val totalBudgetForSpecificDate =
                totalBudgetUseCase.getTotalBudgetForSpecificDate(currentDateTime.dateModel.year,
                    currentDateTime.dateModel.month)
//            withContext(Dispatchers.Main){
//                totalBudgetForSpecificDate?.let {
//                    _budgetInfoUiState.value=BudgetInfo(
//                        totalBudgetForSpecificDate.budgetAmount
//                    )
//                }
            }
        }

    data class BudgetInfo(
        val totalBudgetAmount: Long,
        val monthName: String,
        val showEmptyPageText: String,
    )

}