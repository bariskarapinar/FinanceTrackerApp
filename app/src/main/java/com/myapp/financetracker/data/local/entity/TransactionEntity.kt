package com.myapp.financetracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.myapp.financetracker.domain.model.Transaction
import com.myapp.financetracker.domain.model.TransactionType
import java.time.LocalDateTime

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String,
    val amount: Double,
    val type: String, // INCOME or EXPENSE
    val category: String,
    val date: String, // Stored as ISO string
    val note: String
)

fun TransactionEntity.toTransaction(): Transaction {
    return Transaction(
        id = id,
        title = title,
        amount = amount,
        type = TransactionType.valueOf(type),
        category = category,
        date = LocalDateTime.parse(date),
        note = note
    )
}

fun Transaction.toEntity(): TransactionEntity {
    return TransactionEntity(
        id = id,
        title = title,
        amount = amount,
        type = type.name,
        category = category,
        date = date.toString(),
        note = note
    )
}
