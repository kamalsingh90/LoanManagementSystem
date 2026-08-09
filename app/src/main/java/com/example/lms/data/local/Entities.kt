package com.example.lms.data.local
import androidx.room.*
@Entity(tableName="loans") data class LoanEntity(@PrimaryKey(autoGenerate=true) val id:Long=0,val customerId:String,val amount:Double,val purpose:String,val annualRate:Double,val tenureMonths:Int,val emiDate:Int,val status:String="PENDING",val createdAt:Long=System.currentTimeMillis())
@Entity(tableName="payments") data class PaymentEntity(@PrimaryKey(autoGenerate=true) val id:Long=0,val loanId:Long,val amount:Double,val paymentMode:String,val paidAt:Long=System.currentTimeMillis(),val status:String="SUCCESS")
@Dao interface LoanDao { @Insert suspend fun insertLoan(l:LoanEntity):Long; @Query("SELECT * FROM loans WHERE customerId=:id ORDER BY createdAt DESC") fun loans(id:String):kotlinx.coroutines.flow.Flow<List<LoanEntity>>; @Query("UPDATE loans SET status=:s WHERE id=:id") suspend fun status(id:Long,s:String) }
@Dao interface PaymentDao { @Insert suspend fun insert(p:PaymentEntity); @Query("SELECT * FROM payments WHERE loanId=:id ORDER BY paidAt DESC") fun payments(id:Long):kotlinx.coroutines.flow.Flow<List<PaymentEntity>> }
@Database(entities=[LoanEntity::class,PaymentEntity::class],version=1,exportSchema=false) abstract class AppDatabase:RoomDatabase(){abstract fun loanDao():LoanDao;abstract fun paymentDao():PaymentDao}
