package java_synchronized.test;

public class A extends Thread{

    Object o = new Object();

    public void run(String msg) {
        synchronized (o){
            System.out.println(msg + "lock");
            System.out.println(msg + "unlock");
        }
    }

}
