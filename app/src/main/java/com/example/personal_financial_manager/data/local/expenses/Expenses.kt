package com.example.personal_financial_manager.data.local.expenses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expenses(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "Title") val title: String,
    @ColumnInfo(name = "Price") val price: Long,
    @ColumnInfo(name = "Date") val date: Long,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "BudgetingCategory") val budgetingCategory: String,
)