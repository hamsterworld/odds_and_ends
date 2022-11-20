package java_synchronized;


/**
 * 인스턴스가 달라지면 걸리는 lock 도 당연히 달라진다.
 */
public class basic_synchronized5 {

    public static void main(String[] args) {

        basic_synchronized5 bs = new basic_synchronized5();
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
                account1.print("쓰레드2");
            }
            System.out.println("스레드2이 종료됩니다.");
        }).start();

    }

    public class Account {
        public void print(String msg){
            synchronized (this){
                System.out.println(msg + "lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(msg + "unlock");
            }
        }

    }


}
