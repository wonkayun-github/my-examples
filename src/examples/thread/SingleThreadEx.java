package examples.thread;

public class SingleThreadEx extends Thread {

    final private int[] temp;

    public SingleThreadEx(String name) {
        super(name);
        temp = new int[10];

        for (int start = 0; start < temp.length; start++) {
            temp[start] = start;
        }
    }

    public void run() {
        for(int start:temp) {
            try {
                Thread.sleep(300);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
                // TdDo : handle exception
            }
            System.out.println("Thread name : " + currentThread().getName());
            System.out.println(" temp value : " + start);
        }
    }

    public static void main(String[] args) {
        SingleThreadEx st = new SingleThreadEx("First Thread");
        st.start();
    }
}

