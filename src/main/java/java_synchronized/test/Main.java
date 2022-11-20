package java_synchronized.test;

/**
 * 여러번 돌려봐라.
 * 그럼 원하는 결과가 나옴
 */
public class Main {

    public static void main(String[] args) {

        A a = new A();

        new Thread(() -> {
            System.out.println("스레드2이 실행됩니다.");
            int i =0;
            while(i < 10){
                i++;
                a.run("쓰레드2");

            }
            System.out.println("스레드2이 종료됩니다.");
        }).start();

        new Thread(() -> {
            System.out.println("스레드1이 실행됩니다.");
            int i =0;
            while(i < 10){
                i++;
                a.run("쓰레드1");

            }
            System.out.println("스레드1이 종료됩니다.");
        }).start();



    }
}
