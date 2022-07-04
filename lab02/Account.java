/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {
    /**实例变量*/
    private int balance;
    private Account parentAccount;

    /** Initialize an account with the given balance. */
    public Account(int balance) {
        this.balance = balance;
        //Account parentAccount;
        this.parentAccount = null;
    }
    /**构造函数*/
    public Account(int balance,Account parentAccount) {
        this.balance =balance;
        this.parentAccount = parentAccount;

    }


    /** Returns the balance for the current account. */
    public int getBalance() {
        return this.balance;
    }

    /** Deposits amount into the current account. */
    public void deposit(int amount) { //存储
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            this.balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) { //提取
        if (amount < 0) {
            System.out.println("Cannot withdraw negative amount.");
            return false;
        } else if (this.balance < amount) {
            if (parentAccount!=null&& (parentAccount.balance+this.balance >= amount)) {
                this.balance -= amount;
                parentAccount.balance += this.balance;
                this.balance =0;
                return true;
            }
            System.out.println("Insufficient funds");
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }

    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {
        this.balance = this.balance + other.getBalance();
        other.balance = 0;
    }

    public static void main(String[] args) {
        Account zephyr = new Account(500);
        Account max = new Account(100, zephyr);
        max.withdraw(50);
    }
}
