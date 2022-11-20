package java_synchronized;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * synchronized block 을 사용해보자.
 *
 * synchronized (this)는 사실상 매서드전체로 걸어준다면
 * synchronized method 랑 별반 차이가 없다.
 *
 * 인스턴스가 달라지면 걸리는 lock 도 당연히 달라진다.
 */
public class basic_synchronized4 {

    public static void main(String[] args) {

        basic_synchronized4 bs = new basic_synchronized4();
        Runnable threadAccount = bs.new ThreadAccount();
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

        public int getBalance(){
            return balance;
        }


        public void withdraw(int money,String msg){
            synchronized (this){
                if(balance >= money){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(msg+"이 돈빼는중");
                    balance -= money;
                }
        }
    }

    }

    public class ThreadAccount implements Runnable {

        Account account = new Account();

        @Override
        public void run() {

            while(account.balance > 0){
                int money = (int)(Math.random() * 3 + 1) * 100;
                account.withdraw(money,"돈빼는중");
                System.out.println("balance: " +account.getBalance());
            }

        }
    }


}
