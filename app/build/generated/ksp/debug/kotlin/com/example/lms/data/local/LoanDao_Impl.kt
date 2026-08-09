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
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class LoanDao_Impl(
  __db: RoomDatabase,
) : LoanDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfLoanEntity: EntityInsertAdapter<LoanEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfLoanEntity = object : EntityInsertAdapter<LoanEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `loans` (`id`,`customerId`,`amount`,`purpose`,`annualRate`,`tenureMonths`,`emiDate`,`status`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: LoanEntity) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.customerId)
        statement.bindDouble(3, entity.amount)
        statement.bindText(4, entity.purpose)
        statement.bindDouble(5, entity.annualRate)
        statement.bindLong(6, entity.tenureMonths.toLong())
        statement.bindLong(7, entity.emiDate.toLong())
        statement.bindText(8, entity.status)
        statement.bindLong(9, entity.createdAt)
      }
    }
  }

  public override suspend fun insertLoan(l: LoanEntity): Long = performSuspending(__db, false, true)
      { _connection ->
    val _result: Long = __insertAdapterOfLoanEntity.insertAndReturnId(_connection, l)
    _result
  }

  public override fun loans(id: String): Flow<List<LoanEntity>> {
    val _sql: String = "SELECT * FROM loans WHERE customerId=? ORDER BY createdAt DESC"
    return createFlow(__db, false, arrayOf("loans")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCustomerId: Int = getColumnIndexOrThrow(_stmt, "customerId")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfPurpose: Int = getColumnIndexOrThrow(_stmt, "purpose")
        val _columnIndexOfAnnualRate: Int = getColumnIndexOrThrow(_stmt, "annualRate")
        val _columnIndexOfTenureMonths: Int = getColumnIndexOrThrow(_stmt, "tenureMonths")
        val _columnIndexOfEmiDate: Int = getColumnIndexOrThrow(_stmt, "emiDate")
        val _columnIndexOfStatus: Int = getColumnIndexOrThrow(_stmt, "status")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _result: MutableList<LoanEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: LoanEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpCustomerId: String
          _tmpCustomerId = _stmt.getText(_columnIndexOfCustomerId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpPurpose: String
          _tmpPurpose = _stmt.getText(_columnIndexOfPurpose)
          val _tmpAnnualRate: Double
          _tmpAnnualRate = _stmt.getDouble(_columnIndexOfAnnualRate)
          val _tmpTenureMonths: Int
          _tmpTenureMonths = _stmt.getLong(_columnIndexOfTenureMonths).toInt()
          val _tmpEmiDate: Int
          _tmpEmiDate = _stmt.getLong(_columnIndexOfEmiDate).toInt()
          val _tmpStatus: String
          _tmpStatus = _stmt.getText(_columnIndexOfStatus)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          _item =
              LoanEntity(_tmpId,_tmpCustomerId,_tmpAmount,_tmpPurpose,_tmpAnnualRate,_tmpTenureMonths,_tmpEmiDate,_tmpStatus,_tmpCreatedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun status(id: Long, s: String) {
    val _sql: String = "UPDATE loans SET status=? WHERE id=?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, s)
        _argIndex = 2
        _stmt.bindLong(_argIndex, id)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
