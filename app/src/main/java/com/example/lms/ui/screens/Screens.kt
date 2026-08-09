package com.example.lms.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lms.data.local.LoanEntity
import com.example.lms.domain.EmiCalculator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar

@Composable
fun Col(content: @Composable ColumnScope.() -> Unit) = Column(
    Modifier
        .fillMaxSize()
        .padding(20.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
    content = content
)

@Composable
fun Back(title: String, back: () -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        TextButton(back) { Text("Back") };Text(
        title,
        style = MaterialTheme.typography.headlineSmall
    )
    }
}

@Composable
fun LoginScreen(login: () -> Unit) {
    Col {
        Spacer(Modifier.height(40.dp));Text(
        "Loan Management System",
        style = MaterialTheme.typography.headlineMedium
    );
        var mobile by remember { mutableStateOf("") };OutlinedTextField(
        mobile,
        { mobile = it },
        label = { Text("Mobile Number") },
        modifier = Modifier.fillMaxWidth()
    );Button(
        login,
        Modifier.fillMaxWidth(),
        enabled = mobile.length >= 10
    ) { Text("Send OTP") };Text("Prototype: OTP is simulated locally.")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    loans: List<LoanEntity>,
    apply: () -> Unit,
    kyc: () -> Unit,
    pay: () -> Unit,
    support: () -> Unit
) {
    Scaffold(topBar = { TopAppBar({ Text("Customer Dashboard") }) }) { pad ->
        LazyColumn(
            Modifier
                .padding(
                    pad
                )
                .padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Text(
                    "Welcome, Customer",
                    style = MaterialTheme.typography.headlineSmall
                )
            };item {
            Button(
                apply,
                Modifier.fillMaxWidth()
            ) { Text("Apply for Loan") }
        };item {
            OutlinedButton(
                kyc,
                Modifier.fillMaxWidth()
            ) { Text("KYC & Documents") }
        };item {
            OutlinedButton(
                pay,
                Modifier.fillMaxWidth()
            ) { Text("Payment History") }
        };item {
            OutlinedButton(
                support,
                Modifier.fillMaxWidth()
            ) { Text("Support") }
        };item {
            Text(
                "My Loans",
                style = MaterialTheme.typography.titleLarge
            )
        };if (loans.isEmpty()) item { Text("No applications yet.") } else items(loans) { l ->
            Card(
                Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Loan #${l.id}");Text("₹${"%,.2f".format(l.amount)}");Text(
                    l.purpose
                );Text("Status: ${l.status}")
                }
            }
        }
        }
    }
}

@Composable
fun LoanApplicationScreen(back: () -> Unit, submit: (Double, String, Double, Int, Int) -> Unit) {
    var a by remember { mutableStateOf("100000") };
    var p by remember { mutableStateOf("Personal") };
    var r by remember { mutableStateOf("12") };
    var m by remember { mutableStateOf("24") };
    var d by remember { mutableStateOf("5") };
    val emi = EmiCalculator.calculate(
        a.toDoubleOrNull() ?: 0.0,
        r.toDoubleOrNull() ?: 0.0,
        m.toIntOrNull() ?: 0
    );Col {
        Back("Loan Application", back);OutlinedTextField(
        a,
        { a = it },
        label = { Text("Loan Amount") },
        modifier = Modifier.fillMaxWidth()
    );OutlinedTextField(
        p,
        { p = it },
        label = { Text("Purpose") },
        modifier = Modifier.fillMaxWidth()
    );OutlinedTextField(
        r,
        { r = it },
        label = { Text("Annual Interest %") },
        modifier = Modifier.fillMaxWidth()
    );OutlinedTextField(
        m,
        { m = it },
        label = { Text("Tenure Months") },
        modifier = Modifier.fillMaxWidth()
    );OutlinedTextField(
        d,
        { d = it },
        label = { Text("EMI Date") },
        modifier = Modifier.fillMaxWidth()
    );Card {
        Column(Modifier.padding(16.dp)) {
            Text("EMI: ₹${"%,.2f".format(emi.emi)}");Text(
            "Interest: ₹${
                "%,.2f".format(
                    emi.interest
                )
            }"
        );Text("Total: ₹${"%,.2f".format(emi.total)}")
        }
    };Button({
        submit(
            a.toDoubleOrNull() ?: 0.0,
            p,
            r.toDoubleOrNull() ?: 0.0,
            m.toIntOrNull() ?: 0,
            d.toIntOrNull()?.coerceIn(1, 28) ?: 5
        )
    }, Modifier.fillMaxWidth()) { Text("Submit Application") }
    }
}

@Composable
fun KycScreen(back: () -> Unit) {
    var msg by remember { mutableStateOf("") };Col {
        Back(
            "KYC & Documents",
            back
        );Text("Aadhaar, PAN, address, bank and document verification");
        var aad by remember { mutableStateOf("") };
        var pan by remember { mutableStateOf("") };OutlinedTextField(
        aad,
        { aad = it },
        label = { Text("Aadhaar") },
        modifier = Modifier.fillMaxWidth()
    );OutlinedTextField(
        pan,
        { pan = it },
        label = { Text("PAN") },
        modifier = Modifier.fillMaxWidth()
    );Button(
        { msg = "KYC submitted for verification." },
        Modifier.fillMaxWidth()
    ) { Text("Submit KYC") };Text(msg)
    }
}

@Composable
fun PaymentHistoryScreen(loans: List<LoanEntity>, back: () -> Unit) {
    Col {
        Back(
            "Payment History",
            back
        );if (loans.isEmpty()) Text("No payments.") else loans.forEach { Text("Loan #${it.id} — payment history is stored in Room") }
    }
}

@Composable
fun SupportScreen(back: () -> Unit) {
    var text by remember { mutableStateOf("") };
    var sent by remember { mutableStateOf(false) };Col {
        Back("Support", back);OutlinedTextField(
        text,
        { text = it },
        label = { Text("Message") },
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    );Button(
        { sent = true },
        enabled = text.isNotBlank()
    ) { Text("Send Request") };if (sent) Text("Support request created.")
    }
}
