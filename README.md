# Loan Management System Android Prototype

Based on the supplied LMS proposal. The proposal covers customer website, Android app, admin panel and super-admin panel. This Android project implements a runnable customer prototype with simulated OTP, loan application, EMI calculation, KYC form, payment history, support, Room and Hilt.

The production proposal also requires real Aadhaar/PAN/bank verification, secure document storage, loan verification/risk assessment, disbursement, UPI/net banking/cards, SMS/email/WhatsApp, reports, RBAC and server APIs. Those require a backend, approved third-party providers and credentials; this prototype does not fake them.

Build: Android SDK 36, JDK 17, AGP 8.11.2, Gradle 8.13. core-ktx is pinned to 1.17.0 to avoid the core-ktx 1.19.0/AGP mismatch.
