package com.myapp.financetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.financetracker.domain.model.Transaction
import com.myapp.financetracker.domain.usecase.AddTransactionUseCase
import com.myapp.financetracker.domain.usecase.FinanceSummary
import com.myapp.financetracker.domain.usecase.GetFinanceSummaryUseCase
import com.myapp.financetracker.domain.usecase.GetTransactionsUseCase
import com.myapp.financetracker.data.util.SampleData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TransactionUiState(
    val transactions: List<Transaction> = emptyList(),
    val summary: FinanceSummary = FinanceSummary(0.0, 0.0, 0.0),
    val isLoading: Boolean = false
)

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val getTransactionsUseCase: GetTransactionsUseCase,
    private val getFinanceSummaryUseCase: GetFinanceSummaryUseCase,
    private val addTransactionUseCase: AddTransactionUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(TransactionUiState())
    val state: StateFlow<TransactionUiState> = _state.asStateFlow()

    init {
        loadData()
        seedDatabaseIfEmpty()
    }

    private fun seedDatabaseIfEmpty() {
        viewModelScope.launch {
            val transactions = getTransactionsUseCase().first()
            if (transactions.isEmpty()) {
                SampleData.transactions.forEach {
                    addTransactionUseCase(it)
                }
            }
        }
    }

    private fun loadData() {
        _state.value = _state.value.copy(isLoading = true)
        
        getTransactionsUseCase().onEach { transactions ->
            _state.value = _state.value.copy(
                transactions = transactions,
                isLoading = false
            )
        }.launchIn(viewModelScope)

        getFinanceSummaryUseCase().onEach { summary ->
            _state.value = _state.value.copy(summary = summary)
        }.launchIn(viewModelScope)
    }

    fun addTransaction(transaction: Transaction) {
        viewModelScope.launch {
            addTransactionUseCase(transaction)
        }
    }
}
