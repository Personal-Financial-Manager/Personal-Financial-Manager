package com.example.personal_financial_manager.data.local

import android.content.Context
import androidx.room.Room

object FinancialDatabaseBuilder {

    private var INSTANCE: FinancialDatabase? = null

    fun getInstance(context: Context): FinancialDatabase {
        if (INSTANCE == null) {
            synchronized(FinancialDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            FinancialDatabase::class.java,
            "FinancialAppDb"
        ).build()
}