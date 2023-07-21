package com.example.personal_financial_manager.expenses

import com.example.personal_financial_manager.data.ExpensesRepository
import com.example.personal_financial_manager.data.ExpensesRepositoryImp
import com.example.personal_financial_manager.usecase.expenses.ExpensesUseCase
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExpensesUseCaseTest {

    private lateinit var testSubject: ExpensesUseCase
    private lateinit var repository: ExpensesRepository

    @BeforeAll
    fun init() {
        repository = ExpensesRepositoryImp()
        testSubject = ExpensesUseCase(repository)
    }

    @Test
    fun fetchExpenses_emptyInput_returnsListOfExpenses() {
        val expensesList = testSubject.fetchExpenses()
        assertEquals(0, expensesList.size)
    }
}