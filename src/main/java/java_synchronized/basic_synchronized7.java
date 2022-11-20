package java_synchronized;


/**
 * synchronized 도 또한 매서드별로 적용된다.
 *
 * 사실 이게 큰의미가 싶긴하다 그래도 한번 생각해보면
 *
 * 인스턴스에서 synch(b) 가 걸린 매서드가 2개있으면
 * 이 2개는 이인스턴스에서는 공통 lock을 가지고있을수도?
 *
 * 이인스턴스에 synch(a) 라는 lock을 달리하는 것같다.
 *
 * 사실이렇게 따지면 의미가 없는거같긴하다.
 * 그래도 뭐 a.method() 이렇게도 사용할수있고 뭐 어쨋든 사용용도가 생기겟지
 *
 * 일단 총정리를 해보자면.
 *
 * synmethod 에서는
 * 1.인스턴스마다 적용된다. 그러므로 인스턴스가 달라지면 적용이 안된다.
 *
 * synblock 에서는
 * 1. 인스턴스마다 적용된다. 그러므로 인스턴스가 달라지면 적용이 안된다.
 * 2. synblock(this)는 사실상 synmethod랑 동일하다.
 * 3. synblock(o1) synblock(o2)는 이제 각 lock을 달리한다. --> 사실상 이 o1을 공유하는 lock 은 전부 임계영역에걸린다.
 * 생각하는 그방식이 맞다. test package 를 참고하라. lock 객체를 다양하게줘서 임계영역을 다양하게 설정가능하다.
 * 4. o1,o2을 또 { }내부에서 사용할수있다. 사실이건 뭐 당연한거인듯?
 *
 */
public class basic_synchronized7 {

    Object o = new Object(); //이것도 나중에좀보자 static 영역에서 heap 이 생성되네 new 를 어떻게 쓰는거지?

    public static void main(String[] args) {

        basic_synchronized7 bs = new basic_synchronized7();
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

//        new Thread(() -> {
//            System.out.println("스레드3이 실행됩니다.");
//            int i = 0;
//            while(i < 10){
//                i++;
//                account.print("스레드 3");
//            }
//            System.out.println("스레드3이 종료됩니다.");
//        }).start();

    }

    public class Account {
        private int balance = 1000;

        public int getBalance(){
            return balance;
        }


        public void withdraw(int money,String msg){
            synchronized (o){
                if(balance >= money){
                    try{
                        Thread.sleep(1000);
                        System.out.println("b lock 전에 " + msg );
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(msg+"이 돈빼는중");
                    balance -= money;
                }
            }
        }

        public void print(String msg)  {
                System.out.println("print print" + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
