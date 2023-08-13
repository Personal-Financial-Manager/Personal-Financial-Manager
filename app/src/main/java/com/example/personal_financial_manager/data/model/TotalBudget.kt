package com.example.personal_financial_manager.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.personal_financial_manager.data.local.entity.TotalBudgetEntity

@Entity
data class TotalBudget(
    @PrimaryKey(autoGenerate = true)  val id: Int,
    @ColumnInfo(name = "Year") val year: Int,
    @ColumnInfo(name = "Month") val month: Int,
    @ColumnInfo(name = "Amount") val amount: Long,
)

fun TotalBudgetEntity.mapToTotalBudget(): TotalBudget {
    return TotalBudget(
        this.id,
        this.year,
        this.month,
        this.amount
    )
}