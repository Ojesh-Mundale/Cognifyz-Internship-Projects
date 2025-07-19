import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 1000;
    private final Lock lock = new ReentrantLock();


    public void deposit(int amount, String user) {
        lock.lock();
        try {
            System.out.println(user + " is depositing Rs" + amount);
            balance += amount;
            System.out.println("New Balance after deposit: Rs" + balance);
        } finally {
            lock.unlock();
        }
    }

    
    public void withdraw(int amount, String user) {
        lock.lock();
        try {
            System.out.println(user + " is trying to withdraw Rs" + amount);
            if (balance >= amount) {
                balance -= amount;
                System.out.println(user + " successfully withdraw. Remaining Balance: Rs" + balance);
            } else {
                System.out.println(user + " failed to withdraw due to insufficient funds. Balance: Rs" + balance);
            }
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}

class UserThread extends Thread {
    private final BankAccount account;
    private final String userName;

    public UserThread(BankAccount account, String userName) {
        this.account = account;
        this.userName = userName;
    }

    @Override
    public void run() {
        account.deposit(300, userName);

        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.withdraw(500, userName);
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        UserThread user1 = new UserThread(account, "User1");
        UserThread user2 = new UserThread(account, "User2");
        UserThread user3 = new UserThread(account, "User3");

        user1.start();
        user2.start();
        user3.start();
    }
}
