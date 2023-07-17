package com.example.personal_financial_manager.ui.budget

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personal_financial_manager.R
import com.example.personal_financial_manager.data.enum.MoneyUnit
import com.example.personal_financial_manager.di.JalalliCalendar1
import com.example.personal_financial_manager.usecase.budget.TotalBudgetUseCase
import com.example.personal_financial_manager.util.CalendarInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BudgetListViewModel @Inject constructor(
    private val totalBudgetUseCase: TotalBudgetUseCase,
    @JalalliCalendar1 private val jalalliCalendarHelper: CalendarInterface,
) : ViewModel() {

    private var _budgetUiState = MutableLiveData<BudgetUiState>()
    var budgetUiState: LiveData<BudgetUiState> = _budgetUiState

    init {
        isUserSetBudget()
    }

    private fun isUserSetBudget() {
        viewModelScope.launch {
            val currentDateTime = jalalliCalendarHelper.getCurrentDateTime()
            val budget =
                totalBudgetUseCase.getTotalBudgetForSpecificDate(currentDateTime.dateModel.year,
                    currentDateTime.dateModel.month)
            withContext(Dispatchers.Main) {
                budget?.let {
                    _budgetUiState.value = BudgetUiState(it.amount, jalalliCalendarHelper.getCurrentMonthName())
                } ?: apply {
                    _budgetUiState.value = BudgetUiState(
                        0,
                        jalalliCalendarHelper.getCurrentMonthName(),
                        R.string.enter_budget)
                }
            }
        }
    }

    data class BudgetUiState(
        val totalBudgetAmount: Long,
        val monthName: String,
        val showEmptyPageText: Int? = null,
        val moneyUnit: MoneyUnit = MoneyUnit.TOMAN,
    )
}