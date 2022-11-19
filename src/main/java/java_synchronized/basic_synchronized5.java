package java_synchronized;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class basic_synchronized5 {


    public static void main(String[] args) {

        basic_synchronized5 bs = new basic_synchronized5();


        Thread thread1 = new Thread(() -> {
            System.out.println("스레드1 시작 " + LocalDateTime.now());
            bs.syncBlockMethod1("스레드1");
            System.out.println("스레드1 종료 " + LocalDateTime.now());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("스레드2 시작 " + LocalDateTime.now());
            bs.syncBlockMethod2("스레드2");
            System.out.println("스레드2 종료 " + LocalDateTime.now());
        });

        thread1.start();
        thread2.start();

    }

    private synchronized void syncBlockMethod1(String msg) {

        System.out.println("여기선 나도 자유롭지 못해 1");

        int i = 0;
        while(i < 5){
            System.out.println("method1 중간에 끼여드나요?1");
            System.out.println("method1 중간에 끼여드나요?2");
            System.out.println("method1 중간에 끼여드나요?3");
            System.out.println("method1 중간에 끼여드나요?4");
            i++;
            System.out.println(msg + "의 syncBlockMethod1 실행중" + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void syncBlockMethod2(String msg) {

        System.out.println("여기선 나도 자유롭지 못해 2");

        int i = 0;
        while(i < 5){
            System.out.println("method2 중간에 끼여드나요?1");
            System.out.println("method2 중간에 끼여드나요?2");
            System.out.println("method2 중간에 끼여드나요?3");
            System.out.println("method2 중간에 끼여드나요?4");
            i++;
            System.out.println(msg + "의 syncBlockMethod2 실행중" + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
}
