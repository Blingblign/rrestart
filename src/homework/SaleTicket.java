package homework;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 实现一个由A、B、C三个窗口同时销售100张票的系统，
 * 要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread a = new Thread(ticket);
        Thread b = new Thread(ticket);
        Thread c = new Thread(ticket);
        a.setName("窗口A");
        b.setName("窗口B");
        c.setName("窗口C");
        a.start();
        b.start();
        c.start();

    }
}
class Ticket implements Runnable{
    private int ticket  = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notifyAll();
                if (ticket <= 0) break;
                System.out.println(Thread.currentThread().getName()+":票号__"+ticket--);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
