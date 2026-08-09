package com.example.lms.ui
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.*
import com.example.lms.ui.screens.*
@Composable fun AppNav(){val n=rememberNavController();val vm:LmsViewModel=hiltViewModel();NavHost(n,"login"){
composable("login"){LoginScreen{n.navigate("dashboard"){popUpTo("login"){inclusive=true}}}}
composable("dashboard"){DashboardScreen(vm.loans.value,{n.navigate("loan")},{n.navigate("kyc")},{n.navigate("payments")},{n.navigate("support")})}
composable("loan"){LoanApplicationScreen({n.popBackStack()}){a,p,r,m,d->vm.addLoan(a,p,r,m,d);n.popBackStack()}}
composable("kyc"){KycScreen{n.popBackStack()}}
composable("payments"){PaymentHistoryScreen(vm.loans.value){n.popBackStack()}}
composable("support"){SupportScreen{n.popBackStack()}}
}}
