package com.myapp.financetracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myapp.financetracker.ui.screen.AddTransactionScreen
import com.myapp.financetracker.ui.screen.TransactionListScreen
import com.myapp.financetracker.ui.viewmodel.TransactionViewModel

sealed class Screen(val route: String) {
    object TransactionList : Screen("transaction_list")
    object AddTransaction : Screen("add_transaction")
}

@Composable
fun NavGraph(navController: NavHostController) {
    val viewModel: TransactionViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.TransactionList.route
    ) {
        composable(Screen.TransactionList.route) {
            TransactionListScreen(
                viewModel = viewModel,
                onAddTransactionClick = {
                    navController.navigate(Screen.AddTransaction.route)
                }
            )
        }
        composable(Screen.AddTransaction.route) {
            AddTransactionScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
