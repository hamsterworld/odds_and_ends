package java_synchronized.test;

public class A extends Thread{

    Object o = new Object();

    public synchronized void run(String msg) {
            System.out.println(msg + "lock");
            System.out.println(msg + "unlock");
    }

}
