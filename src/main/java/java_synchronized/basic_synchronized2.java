package java_synchronized;

/**
 * 동시성 문제 해결
 */
public class basic_synchronized2 {

    public static void main(String[] args) {

        basic_synchronized2 bs = new basic_synchronized2();
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

        public synchronized void withdraw(int money,String msg){
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

//        public void withdraw(int money,String msg){
//            synchronized (this){
//                if(balance >= money){
//                    try{
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                    System.out.println(msg+"이 돈빼는중");
//                    balance -= money;
//                }
//        }
//    }
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
