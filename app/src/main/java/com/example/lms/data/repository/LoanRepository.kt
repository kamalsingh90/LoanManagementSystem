package com.example.lms.data.repository
import com.example.lms.data.local.*
import javax.inject.Inject
class LoanRepository @Inject constructor(private val l:LoanDao,private val p:PaymentDao){fun loans(id:String)=l.loans(id);suspend fun add(x:LoanEntity)=l.insertLoan(x);suspend fun payment(x:PaymentEntity)=p.insert(x);fun payments(id:Long)=p.payments(id)}
