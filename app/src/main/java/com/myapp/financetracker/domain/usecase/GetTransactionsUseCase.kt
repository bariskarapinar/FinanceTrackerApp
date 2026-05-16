package com.myapp.financetracker.domain.usecase

import com.myapp.financetracker.domain.model.Transaction
import com.myapp.financetracker.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(
    private val repository: FinanceRepository
) {
    operator fun invoke(): Flow<List<Transaction>> {
        return repository.getAllTransactions()
    }
}
