package java_synchronized.thread_IO_Blocking;

import javax.swing.*;

public class ThreadBlocking {

    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog("아무 값이나 입력해주세요.");
        System.out.println(" 입력하신값은 " + input + "입니다.");

        for(int i =0;i<10;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
