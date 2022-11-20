package java_synchronized;


/**
 * synchronized 도 또한 매서드별로 적용된다.
 *
 * synchronized 에 파라미터에는 lock 객체가 들어가는데
 * 애를통해서, 특정 동기화키워드만 동기화시켜줄수잇고 그런것같다.
 *
 *
 * 인스턴스가 달라지면 당연히 lock 은 달라진다.
 * 그리고 아까와 같은 account는 아니지만.
 * 중간에 lock -> unlock까지 다해야지 lock이 들어있기때문에 동시성이 안터질수있는데
 * 애는 중간에 끊긴다 만약에 동시성문제가 터질수있는 매서드였다면 터졌을것.
 *
 */
public class basic_synchronized6 {

    B b = new B();

    public static void main(String[] args) {

        basic_synchronized6 bs = new basic_synchronized6();
        Account account = bs.new Account();
        Account account1 = bs.new Account();

        new Thread(() -> {
            System.out.println("스레드1이 실행됩니다.");
            int i =0;
            while(i < 4){
                i++;
                account.print("쓰레드1");
            }
            System.out.println("스레드1이 종료됩니다.");
        }).start();

        new Thread(() -> {
            System.out.println("스레드2이 실행됩니다.");
            int i =0;
            while(i < 4){
                i++;
                account.print("쓰레드2");
            }
            System.out.println("스레드2이 종료됩니다.");
        }).start();

        new Thread(() -> {
            System.out.println("스레드3이 실행됩니다.");
            int i = 0;
            while(i < 10){
                i++;
                account.print1("스레드 3");
            }
            System.out.println("스레드3이 종료됩니다.");
        }).start();


    }

    public class Account {
        public void print(String msg){
            synchronized (b){
                System.out.println(msg + "lock");
                try {
                    Thread.sleep(1000);
                    b.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(msg + "unlock");
            }
        }

        public void print1(String msg)  {
            System.out.println("print print" + msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public class B implements Runnable{
        @Override
        public void run() {
            System.out.println("B lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B unlock");
        }
        }

    }



