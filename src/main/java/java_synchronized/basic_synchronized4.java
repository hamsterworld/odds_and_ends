package java_synchronized;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


public class basic_synchronized4 {

    private final Object o1 = new Object();
    private final Object o2 = new Object();

    public static void main(String[] args) {

        basic_synchronized4 bs = new basic_synchronized4();
        Account account = bs.new Account();

        new Thread(() -> {
            System.out.println("스레드1이 실행됩니다.");
            while(account.balance > 0){
                int money = (int)(Math.random() * 3 + 1) * 100;
                account.withdraw(money,"쓰레드1");
                System.out.println("balance1: " +account.getBalance());
            }
            System.out.println("스레드1이 종료됩니다.");
        }).start();

        new Thread(() -> {
            System.out.println("스레드2이 실행됩니다.");
            while(account.balance > 0){
                int money = (int)(Math.random() * 3 + 1) * 100;
                account.withdraw(money,"쓰레드2");
                System.out.println("balance2: " +account.getBalance());
            }
            System.out.println("스레드2이 종료됩니다.");
        }).start();



    }

    public class Account {
        private int balance = 1000;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int money, String msg) {
            synchronized (this){
                if (balance >= money) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(msg + "이 돈빼는중");
                    balance -= money;
                }
            }
        }
    }

}
