package com.myapp.financetracker.domain.model

import java.time.LocalDateTime

data class Transaction(
    val id: Int? = null,
    val title: String,
    val amount: Double,
    val type: TransactionType,
    val category: String,
    val date: LocalDateTime = LocalDateTime.now(),
    val note: String = ""
)

enum class TransactionType {
    INCOME, EXPENSE
}
