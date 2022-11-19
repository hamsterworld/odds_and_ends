package java_synchronized;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 자바에서 static 과 heap 영역은 resource 를 공유하는 영역이므로,
 * 공유리소스에대한 동기화문제는 항상 신경써줘야한다.
 * 그래서 임계영역을 설정해주고 락을 얻은 쓰레드만이 출입 가능하다.
 * 객체 1개당 락 1개
 *
 * 그중하나가 이제 java 의 synchronized 이다.
 *
 * 1. synchronized method (method를 임계영역으로 설정)
 * 2. static synchronized method
 * 3. synchronized block (특정한 영역만 임계영역으로 지정)
 * 4. static synchronized block
 *
 * 네가지에대해서 사용방법을 알아보겠다.
 *
 * synchronized 는 lock 을 이용해 동기화를 수행한다.
 * 자바는 멀티쓰레드가 장점인데, 동기화키워드를 너무남발하면 성능이 당연히 느려진다. 범위를 최소화하자.
 *
 * 아래 예시는 인스턴스하나에 서로다른 쓰레드를 실행한경우.
 */
public class java_synchronized {

    public static void main(String[] args) {

        java_synchronized sync = new java_synchronized();

        Thread thread1 = new Thread(() -> {
            System.out.println("스레드1 시작 " + LocalDateTime.now());
            sync.syncMethod1("스레드1");
            System.out.println("스레드1 종료 " + LocalDateTime.now());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("스레드2 시작 " + LocalDateTime.now());
            sync.syncMethod1("스레드2");
            System.out.println("스레드2 종료 " + LocalDateTime.now());
        });

        thread1.start();
        thread2.start();

    }


    private synchronized void syncMethod1(String msg){
        System.out.println(msg + "의 synMethod1 실행중" + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private synchronized void syncMethod2(String msg){

        System.out.println(msg + "의 synMethod2 실행중" + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
