package com.myapp.financetracker.data.util

import com.myapp.financetracker.domain.model.Transaction
import com.myapp.financetracker.domain.model.TransactionType
import java.time.LocalDateTime

object SampleData {
    val transactions = listOf(
        Transaction(
            title = "Monthly Salary",
            amount = 5000.0,
            type = TransactionType.INCOME,
            category = "Salary",
            date = LocalDateTime.now().minusDays(5)
        ),
        Transaction(
            title = "Grocery Shopping",
            amount = 120.50,
            type = TransactionType.EXPENSE,
            category = "Food",
            date = LocalDateTime.now().minusDays(4)
        ),
        Transaction(
            title = "Rent Payment",
            amount = 1500.0,
            type = TransactionType.EXPENSE,
            category = "Housing",
            date = LocalDateTime.now().minusDays(3)
        ),
        Transaction(
            title = "Freelance Project",
            amount = 800.0,
            type = TransactionType.INCOME,
            category = "Freelance",
            date = LocalDateTime.now().minusDays(2)
        ),
        Transaction(
            title = "Gas Station",
            amount = 60.0,
            type = TransactionType.EXPENSE,
            category = "Transport",
            date = LocalDateTime.now().minusDays(1)
        ),
        Transaction(
            title = "Netflix Subscription",
            amount = 15.99,
            type = TransactionType.EXPENSE,
            category = "Entertainment",
            date = LocalDateTime.now()
        )
    )
}
