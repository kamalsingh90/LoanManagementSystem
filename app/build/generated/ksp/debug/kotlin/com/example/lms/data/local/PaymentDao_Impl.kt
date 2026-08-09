package com.example.lms.`data`.local

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class PaymentDao_Impl(
  __db: RoomDatabase,
) : PaymentDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfPaymentEntity: EntityInsertAdapter<PaymentEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfPaymentEntity = object : EntityInsertAdapter<PaymentEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `payments` (`id`,`loanId`,`amount`,`paymentMode`,`paidAt`,`status`) VALUES (nullif(?, 0),?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: PaymentEntity) {
        statement.bindLong(1, entity.id)
        statement.bindLong(2, entity.loanId)
        statement.bindDouble(3, entity.amount)
        statement.bindText(4, entity.paymentMode)
        statement.bindLong(5, entity.paidAt)
        statement.bindText(6, entity.status)
      }
    }
  }

  public override suspend fun insert(p: PaymentEntity): Unit = performSuspending(__db, false, true)
      { _connection ->
    __insertAdapterOfPaymentEntity.insert(_connection, p)
  }

  public override fun payments(id: Long): Flow<List<PaymentEntity>> {
    val _sql: String = "SELECT * FROM payments WHERE loanId=? ORDER BY paidAt DESC"
    return createFlow(__db, false, arrayOf("payments")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfLoanId: Int = getColumnIndexOrThrow(_stmt, "loanId")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfPaymentMode: Int = getColumnIndexOrThrow(_stmt, "paymentMode")
        val _columnIndexOfPaidAt: Int = getColumnIndexOrThrow(_stmt, "paidAt")
        val _columnIndexOfStatus: Int = getColumnIndexOrThrow(_stmt, "status")
        val _result: MutableList<PaymentEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: PaymentEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpLoanId: Long
          _tmpLoanId = _stmt.getLong(_columnIndexOfLoanId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpPaymentMode: String
          _tmpPaymentMode = _stmt.getText(_columnIndexOfPaymentMode)
          val _tmpPaidAt: Long
          _tmpPaidAt = _stmt.getLong(_columnIndexOfPaidAt)
          val _tmpStatus: String
          _tmpStatus = _stmt.getText(_columnIndexOfStatus)
          _item = PaymentEntity(_tmpId,_tmpLoanId,_tmpAmount,_tmpPaymentMode,_tmpPaidAt,_tmpStatus)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
