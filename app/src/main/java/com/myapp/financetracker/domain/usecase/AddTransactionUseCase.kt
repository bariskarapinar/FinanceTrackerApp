package com.myapp.financetracker.domain.usecase

import com.myapp.financetracker.domain.model.Transaction
import com.myapp.financetracker.domain.repository.FinanceRepository
import javax.inject.Inject

class AddTransactionUseCase @Inject constructor(
    private val repository: FinanceRepository
) {
    suspend operator fun invoke(transaction: Transaction) {
        repository.insertTransaction(transaction)
    }
}
