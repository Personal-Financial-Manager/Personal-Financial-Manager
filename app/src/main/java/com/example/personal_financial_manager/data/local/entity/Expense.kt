package com.example.personal_financial_manager.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "Title") val title: String,
    @ColumnInfo(name = "Amount") val amount: Long,
    @ColumnInfo(name = "Date") val date: Long,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "Category") val category: String,
)