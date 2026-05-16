package com.myapp.financetracker.di

import android.content.Context
import androidx.room.Room
import com.myapp.financetracker.data.local.FinanceDatabase
import com.myapp.financetracker.data.local.dao.TransactionDao
import com.myapp.financetracker.data.repository.FinanceRepositoryImpl
import com.myapp.financetracker.domain.repository.FinanceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FinanceDatabase {
        return Room.databaseBuilder(
            context,
            FinanceDatabase::class.java,
            FinanceDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTransactionDao(db: FinanceDatabase): TransactionDao {
        return db.transactionDao
    }

    @Provides
    @Singleton
    fun provideFinanceRepository(dao: TransactionDao): FinanceRepository {
        return FinanceRepositoryImpl(dao)
    }
}
