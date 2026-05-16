package com.myapp.financetracker.data.repository

import com.myapp.financetracker.data.local.dao.TransactionDao
import com.myapp.financetracker.data.local.entity.toEntity
import com.myapp.financetracker.data.local.entity.toTransaction
import com.myapp.financetracker.domain.model.Transaction
import com.myapp.financetracker.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FinanceRepositoryImpl(
    private val dao: TransactionDao
) : FinanceRepository {
    override fun getAllTransactions(): Flow<List<Transaction>> {
        return dao.getAllTransactions().map { entities ->
            entities.map { it.toTransaction() }
        }
    }

    override suspend fun insertTransaction(transaction: Transaction) {
        dao.insertTransaction(transaction.toEntity())
    }

    override suspend fun deleteTransaction(transaction: Transaction) {
        dao.deleteTransaction(transaction.toEntity())
    }

    override fun getTotalIncome(): Flow<Double> {
        return dao.getTotalIncome().map { it ?: 0.0 }
    }

    override fun getTotalExpense(): Flow<Double> {
        return dao.getTotalExpense().map { it ?: 0.0 }
    }
}
