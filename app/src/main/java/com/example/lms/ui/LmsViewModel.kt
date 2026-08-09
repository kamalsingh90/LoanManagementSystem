package com.example.lms.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lms.data.local.*
import com.example.lms.data.repository.LoanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
@HiltViewModel class LmsViewModel @Inject constructor(private val repo:LoanRepository):ViewModel(){
private val customer="demo-customer"
val loans=repo.loans(customer).stateIn(viewModelScope,SharingStarted.WhileSubscribed(5000),emptyList())
fun addLoan(a:Double,p:String,r:Double,n:Int,d:Int)=viewModelScope.launch{repo.add(LoanEntity(customerId=customer,amount=a,purpose=p,annualRate=r,tenureMonths=n,emiDate=d))}
fun pay(id:Long,a:Double)=viewModelScope.launch{repo.payment(PaymentEntity(loanId=id,amount=a,paymentMode="UPI"))}
}
