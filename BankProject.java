import java.util.*;

class Account {
    String name;
    int accountNumber;
    double balance;
    ArrayList<String> transactions;

    Account(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance Rs0.0");
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited Rs" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew Rs. " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void checkBalance() {
        System.out.println("Current balance: Rs." + balance);
    }

    void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

public class BankProject{
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static Account userAccount = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    if (checkIfAccountExists()) {
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        userAccount.deposit(dep);
                    }
                    break;
                case 3:
                    if (checkIfAccountExists()) {
                        System.out.print("Enter amount to withdraw: ");
                        double wit = sc.nextDouble();
                        userAccount.withdraw(wit);
                    }
                    break;
                case 4:
                    if (checkIfAccountExists()) {
                        userAccount.checkBalance();
                    }
                    break;
                case 5:
                    if (checkIfAccountExists()) {
                        userAccount.viewTransactionHistory();
                    }
                    break;
                case 6:
                    System.out.println("Thank you for choosing us. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void createAccount() {
        if (userAccount != null) {
            System.out.println("Account already created.");
            return;
        }
        System.out.print("Enter your name: ");
        sc.nextLine();
        String name = sc.nextLine();
        int accNum = 100000 + rand.nextInt(900000);
        userAccount = new Account(name, accNum);
        System.out.println("Account created successfully! Account Number: " + accNum);
    }

    static boolean checkIfAccountExists() {
        if (userAccount == null) {
            System.out.println("No account found. Please create an account first.");
            return false;
        }
        return true;
    }
}