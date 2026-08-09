package com.example.lms.di
import android.content.Context
import androidx.room.Room
import com.example.lms.data.local.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module @InstallIn(SingletonComponent::class) object AppModule{
@Provides @Singleton fun db(@ApplicationContext c:Context)=Room.databaseBuilder(c,AppDatabase::class.java,"lms.db").fallbackToDestructiveMigration().build()
@Provides fun loanDao(d:AppDatabase)=d.loanDao()
@Provides fun paymentDao(d:AppDatabase)=d.paymentDao()
}
