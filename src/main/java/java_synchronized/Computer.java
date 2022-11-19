package java_synchronized;

import java.util.Random;

/**
 * 자바에서 static 과 heap 영역은 resource 를 공유하는 영역이므로,
 * 공유리소스에대한 동기화문제는 항상 신경써줘야한다.
 *
 * 그중하나가 이제 java 의 synchronized 이다.
 */
public class Computer {

    public static void main(String[] args) {

        final WebBrowser webBrowser = new WebBrowser(5);

//        new Thread(new Web)

    }

    public class Website implements Runnable{

        private final String webSiteName;
        private final WebBrowser webBrowser;

        public Website(String webSiteName, WebBrowser webBrowser) {
            this.webSiteName = webSiteName;
            this.webBrowser = webBrowser;
        }

        @Override
        public void run() {
            synchronized (this){
                while(webBrowser.hasSpace()){
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    webBrowser.createNewTab(webSiteName);
                }
            }
        }
    }

}
