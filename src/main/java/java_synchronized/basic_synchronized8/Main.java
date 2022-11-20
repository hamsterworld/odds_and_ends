package java_synchronized.basic_synchronized8;

/**
 * static synchronized method 나 synchronized block (*.class)
 * 는 class 단위로 걸려버린다.
 *
 * 즉, 인스턴스가 다르더라도 원래는 다른 임계영역을 취급했지만.
 * class 단위로 걸어버리면 인스턴스가 달라도 임계영역이 모두 같게 취급된다.
 *
 */
public class Main {

    public static void main(String[] args) {
        A a = new A();
        A a1 = new A();

        new Thread(() -> {
            System.out.println("스레드 1을 시작합니다.");
            int i = 0;

            while(i < 5){
                i++;
                a.run("thread1");
            }
            System.out.println("스레드 1을 종료합니다.");
        }).start();

        new Thread(() ->{
            System.out.println("스레드 2을 시작합니다.");
            int i = 0;
            while(i < 5){
                i++;
                a1.run("thread2");
            }
            System.out.println("스레드 2을 종료합니다.");
        }).start();

    }

}
