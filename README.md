# Loan Management System Android Prototype

Based on the supplied LMS proposal. The proposal covers customer website, Android app, admin panel and super-admin panel. This Android project implements a runnable customer prototype with simulated OTP, loan application, EMI calculation, KYC form, payment history, support, Room and Hilt.

The production proposal also requires real Aadhaar/PAN/bank verification, secure document storage, loan verification/risk assessment, disbursement, UPI/net banking/cards, SMS/email/WhatsApp, reports, RBAC and server APIs. Those require a backend, approved third-party providers and credentials; this prototype does not fake them.

Build: Android SDK 36, JDK 17, AGP 8.11.2, Gradle 8.13. core-ktx is pinned to 1.17.0 to avoid the core-ktx 1.19.0/AGP mismatch.

implement the same Loan Management System screens shown above using Kotlin + Jetpack Compose.

# Loan Management System – Android

A prototype Loan Management System developed using Kotlin and Jetpack Compose.

## Working Features

### Customer Authentication
- Mobile number login
- OTP simulation
- Basic input validation

### Customer Dashboard
- View loan applications
- Apply for a new loan
- KYC & document section
- Payment history
- Customer support

### Loan Application
- Enter loan amount
- Select loan purpose
- Enter interest rate
- Select loan tenure
- Select EMI date
- Submit loan application

### EMI Calculator
- Monthly EMI calculation
- Total interest calculation
- Total repayment calculation

### Loan Management
- View submitted loans
- View loan details
- Display loan status
- Display EMI and tenure

### KYC
- Aadhaar details
- PAN details
- Address
- Bank details
- KYC submission flow

### Payment
- Payment history screen
- Demo EMI payment recording
- Payment status

### Support
- Customer support request
- Message submission

## Technology Stack

- Kotlin
- Jetpack Compose
- Material 3
- MVVM
- Hilt
- Room Database
- Navigation Compose
- Retrofit
- Coroutines
- Android SDK 36

## Local Database

Room Database is used to store:

- Loan applications
- Loan details
- Payment records

## Architecture

UI → ViewModel → Repository → Room Database

## Current Status

This is a functional Android prototype.

Implemented locally:
- Customer login flow
- Loan application
- EMI calculation
- Loan storage
- Loan details
- KYC form
- Payment records
- Support request

Production integrations such as real OTP, payment gateway, Aadhaar/PAN verification,
backend APIs, SMS/WhatsApp/email notifications and Admin/Super Admin panels
need to be connected before production deployment.<img width="1536" height="1024" alt="LoanManagementSystem" src="https://github.com/user-attachments/assets/8d06df46-1d17-438e-bcd5-f694dec824a8" />
