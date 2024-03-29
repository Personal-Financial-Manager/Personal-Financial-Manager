package com.example.personal_financial_manager.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TotalBudgetEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "Year") val year: Int,
    @ColumnInfo(name = "Month") val month: Int,
    @ColumnInfo(name = "Amount") val amount: Long
)