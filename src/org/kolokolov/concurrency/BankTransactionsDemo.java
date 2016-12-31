package org.kolokolov.concurrency;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class BankTransactionsDemo {

    public static final int ACCOUNTS_NUMBER = 100;
    public static final int INITIAL_BALANCE = 1000;
    public static final int SLEEP_TIME = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(ACCOUNTS_NUMBER, INITIAL_BALANCE);
        for (int i = 0; i < ACCOUNTS_NUMBER; i++) {
            int from = i;
            new Thread(() -> {
                try {
                    while (true) {
                        int to = (int) (ACCOUNTS_NUMBER * Math.random());
                        int amount = (int) (INITIAL_BALANCE * Math.random());
                        bank.transfer(from, to, amount);
                        Thread.sleep(SLEEP_TIME);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static class Bank {
        private int[] accounts;
        Lock lock = new ReentrantLock();
        Condition enoughMoneyToTransfer = lock.newCondition();

        public Bank(int accountNumber, int initialBalance) {
            accounts = new int[accountNumber];
            Arrays.fill(accounts, initialBalance);
        }

        public void transfer(int from, int to, int amount) {
            lock.lock();
            try {
                while (accounts[from] < amount) {
                    System.out.println("Not enough money on the #" + from);
                    enoughMoneyToTransfer.await();
                }
                System.out.print(Thread.currentThread() + " transfers from #" + from + " to #" + to + " "
                        + amount + " dollars. ");
                accounts[from] -= amount;
                accounts[to] += amount;
                System.out.println("Total balance is: " + getTotalBalance());
                enoughMoneyToTransfer.signalAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock(); 
            }
        }

        public int getTotalBalance() {
            lock.lock();
            try {
                return IntStream.of(accounts).sum();
            } finally {
                lock.unlock();
            }
        }
    }
}
