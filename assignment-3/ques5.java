import java.util.Scanner;

class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {

    InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {

    AccountNotFoundException(String message) {
        super(message);
    }
}

class Bank {

    double balance = 5000;

    void checkAccount(int accountNumber)
            throws AccountNotFoundException {

        if (accountNumber != 12345) {
            throw new AccountNotFoundException(
                "Account not found"
            );
        }
    }

    void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero"
            );
        }

        balance = balance + amount;

        System.out.println("Deposit successful");
    }

    void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero"
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance"
            );
        }

        balance = balance - amount;

        System.out.println("Withdrawal successful");
    }

    double getBalance() {
        return balance;
    }
}

public class BankingApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        try {
            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();

            bank.checkAccount(accountNumber);

            System.out.print("Enter deposit amount: ");
            double depositAmount = sc.nextDouble();

            bank.deposit(depositAmount);

            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = sc.nextDouble();

            bank.withdraw(withdrawalAmount);

            System.out.println(
                "Current balance = " + bank.getBalance()
            );

        }
        catch (AccountNotFoundException e) {

            System.out.println("Error: " + e.getMessage());

        }
        catch (InvalidAmountException e) {

            System.out.println("Error: " + e.getMessage());

        }
        catch (InsufficientBalanceException e) {

            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}