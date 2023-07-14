package com.example.personal_financial_manager.ui.budget

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personal_financial_manager.data.BudgetPlanRepository
import com.example.personal_financial_manager.di.JalalliCalendar1
import com.example.personal_financial_manager.usecase.budget.TotalBudgetUseCase
import com.example.personal_financial_manager.util.CalendarInterface
import com.example.personal_financial_manager.util.JalalliCalendarHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BudgetListViewModel @Inject constructor(

) : ViewModel() {
    @JalalliCalendar1
    @Inject
    lateinit var jalalliCalendarHelper: CalendarInterface

    var _budgetInfoUiState = MutableLiveData<BudgetInfo>()
    var budgetInfoUiState: LiveData<BudgetInfo> = _budgetInfoUiState

    @Inject
    lateinit var totalBudgetUseCase: TotalBudgetUseCase

    @Inject
    lateinit var budgetPlanRepository: BudgetPlanRepository

    init {
        isUserSetBudget()
    }

    private fun isUserSetBudget() {
        viewModelScope.launch {
            val currentDateTime = jalalliCalendarHelper.getCurrentDateTime()
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