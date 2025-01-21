# Bank Management Case Study

## Problem Statement

XYZ Bank aims to automate the core functionalities of one of its branches. The project focuses on automating the following features:

1. **Over the Counter Activities**  
2. **Account Lifecycle Management**  
3. **Interest Calculation**  
4. **End-of-Day Reports for Daily Transactions**  

The bank supports multiple account types, each with specific requirements and functionalities:

- **Savings Account**: Requires an average minimum balance of ₹10,000.  
- **Salary Account**: Similar to a savings account but requires at least one transaction within two months to remain active.  
- **Current Account**: Offers overdraft facilities without specific balance requirements.  
- **Loan Account**: Tracks loan repayment with an initial negative balance (loan amount) and interest calculated accordingly.  

## Requirements

1. **Java JDK (Version SE-22)**  
2. **Eclipse IDE** (used as the development environment).  
3. Basic understanding of OOP concepts in Java.  

## Approach

The project uses an object-oriented programming (OOP) approach to implement various account types and banking operations. It involves encapsulating different functionalities, such as account management, transactions, and reporting, in separate classes and modules.

Key functionalities include:  
- Account creation, search, freezing, and unfreezing.  
- Deposits, withdrawals, and balance checks.  
- End-of-day (EOD) reporting for accounts created and transactions performed.  
- Admin panel for managing all activities.  

## Technologies Used

- **Java**: Core language for implementing the system.  
- **Eclipse IDE**: Development environment.  
- **Date and Time APIs**: Used for handling account lifecycles and reporting.  

## Project Structure

The project follows a modular structure for better maintainability and scalability. Below is an overview:

```plaintext
BankManagementCaseStudy
├── src
│   ├── com.bnkmgmt.account
│   │   ├── Account.java
│   │   ├── AccountUtility.java
│   │   ├── AccTransaction.java
│   │   ├── CurrentAccount.java
│   │   ├── LoanAccount.java
│   │   ├── SalaryAccount.java
│   │   ├── SavingAccount.java
│   ├── com.bnkmgmt.bankmanagement
│   │   ├── MainApp.java
│   ├── com.bnkmgmt.exceptions
│   │   ├── MenuChoiceException.java
│   ├── com.bnkmgmt.finixbank
│   │   ├── AdminOptions.java
│   │   ├── FinixBank.java
│   ├── com.bnkmgmt.finixbank.transactions
│   │   ├── BankAccountsCreated.java
│   │   ├── BankTransaction.java
│   ├── com.bnkmgmt.finixbank.utils
│       ├── BankUtils.java
```

## Code Overview

### MainApp.java
The entry point of the application. It initializes the bank and calls the `StartBank()` method from the `FinixBank` class.

### FinixBank.java
Manages user interactions such as login, account lifecycle management, and balance checks. Handles both customer and admin operations.

### AdminOptions.java
Provides admin functionalities like:  
- Adding new accounts.  
- Freezing/unfreezing accounts.  
- End-of-day reporting for accounts and transactions.  

### Account Types
The following classes define specific account behaviors:  
1. `SavingAccount.java`  
2. `SalaryAccount.java`  
3. `CurrentAccount.java`  
4. `LoanAccount.java`  

### Utilities
- **`BankUtils.java`**: Provides helper methods for searching accounts, formatting dates, and account lifecycle handling.  
- **`AccountUtility.java`**: Contains utility methods like generating account numbers and customer IDs.  

## Usage

1. Clone the repository and import it into **Eclipse IDE**.  
2. Run the `MainApp` class to start the program.  
3. Follow the prompts to log in as an admin or view account details.  

## Features

- **Admin Panel**: Manage accounts, perform transactions, and generate reports.  
- **Dynamic Account Handling**: Supports multiple account types with unique behaviors.  
- **EOD Reporting**: Generates detailed end-of-day reports.  
- **Error Handling**: Uses custom exceptions like `MenuChoiceException`.  

---
