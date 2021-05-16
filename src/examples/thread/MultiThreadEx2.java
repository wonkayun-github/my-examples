package examples.thread;

class ATM implements Runnable {
    private long depositeMoney = 10000;

    public void run() {
        synchronized (this) {

            for (int i = 0; i < 10; i++) {
                notify();
                try {
                    wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (getDepositeMoney() <= 0)
                    break;
                withDraw(1000);
            }
        }
    }

    public void withDraw(long howMuch) {
        if (getDepositeMoney() > 0) {
            depositeMoney -= howMuch;
            System.out.print(Thread.currentThread().getName() + " , ");
            System.out.printf("balance : %,d won %n", getDepositeMoney());
        } else {
            System.out.print(Thread.currentThread().getName() + " , ");
            System.out.println("The balance is insufficient.");
        }
    }

    public long getDepositeMoney() {
        return depositeMoney;
    }
}

class SynchronizedEx {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread mother = new Thread(atm, "mother");
        Thread son = new Thread(atm, "son");
        mother.start();
        son.start();
    }
}