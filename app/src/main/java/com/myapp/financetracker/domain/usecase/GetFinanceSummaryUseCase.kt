package com.myapp.financetracker.domain.usecase

import com.myapp.financetracker.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

data class FinanceSummary(
    val totalIncome: Double,
    val totalExpense: Double,
    val balance: Double
)

class GetFinanceSummaryUseCase @Inject constructor(
    private val repository: FinanceRepository
) {
    operator fun invoke(): Flow<FinanceSummary> {
        return combine(
            repository.getTotalIncome(),
            repository.getTotalExpense()
        ) { income, expense ->
            FinanceSummary(
                totalIncome = income,
                totalExpense = expense,
                balance = income - expense
            )
        }
    }
}
