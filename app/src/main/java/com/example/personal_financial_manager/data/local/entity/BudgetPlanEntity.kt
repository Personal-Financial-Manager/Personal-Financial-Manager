package com.example.personal_financial_manager.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = TotalBudgetEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("BudgetMainFk"),
    onDelete = ForeignKey.CASCADE)])
data class BudgetPlanEntity(
    @PrimaryKey(autoGenerate = true)  val id: Int,
    @ColumnInfo(name = "BudgetMainFk") val budgetMainFk: Int,
    @ColumnInfo(name = "Title") val title: String,
    @ColumnInfo(name = "Icon") val icon: Int,
    @ColumnInfo(name = "Amount") val amount: Long,
    @ColumnInfo(name = "AmountType") val amountType: Int,
)