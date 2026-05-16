package com.myapp.financetracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.myapp.financetracker.data.local.dao.TransactionDao
import com.myapp.financetracker.data.local.entity.TransactionEntity

@Database(entities = [TransactionEntity::class], version = 1)
abstract class FinanceDatabase : RoomDatabase() {
    abstract val transactionDao: TransactionDao

    companion object {
        const val DATABASE_NAME = "finance_db"
    }
}
