package com.myapp.financetracker.domain.repository

import com.myapp.financetracker.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface FinanceRepository {
    fun getAllTransactions(): Flow<List<Transaction>>
    suspend fun insertTransaction(transaction: Transaction)
    suspend fun deleteTransaction(transaction: Transaction)
    fun getTotalIncome(): Flow<Double>
    fun getTotalExpense(): Flow<Double>
}
