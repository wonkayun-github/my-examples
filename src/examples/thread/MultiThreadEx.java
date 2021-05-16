package examples.thread;

public class MultiThreadEx {
    public static void main(String[] args) {

        ThreadEX threadex = new ThreadEX();
        ThreadEX threaded = new ThreadEX();

        Thread thread1 = new Thread(threadex,"A");
        Thread thread2 = new Thread(threaded,"B");

        thread1.start();
        thread2.start();
    }
}

class ThreadEX implements Runnable{

    int TestNum=0;
    @Override
    public /*synchronized 하나가 끝나야 실행됨*/ void run() {
        // TODO Auto-generated method stub
        for(int i=0;i<10;i++){
            if(Thread.currentThread().getName().equals("A")){
                TestNum++;
            }
            System.out.println("ThreadName: " + Thread.currentThread().getName()
                    + ", TestNum: " + TestNum + ", i: " + i);

            try {
                if(Thread.currentThread().getName().equals("A")){
                    Thread.sleep(500);

                } else {
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}