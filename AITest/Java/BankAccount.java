package aitest;

import java.math.BigDecimal;

/** Intentionally defective implementation for AI repair exercises. */
public class BankAccount {
    private BigDecimal balance;

    public BankAccount(BigDecimal openingBalance) {
        balance = openingBalance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public boolean withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            Thread.yield();
            balance = balance.subtract(amount);
            return true;
        }
        return false;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
