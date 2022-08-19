package thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
//        thread1.join(1);
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
    }
}
//创建新线程方式1
class Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            if (i%2 == 0) {
                System.out.println("Thread1线程：偶数"+i);
            }
        }
    }
}
class Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            if (i%2 != 0) {
                System.out.println("Thread2线程：奇数"+i);
            }
        }
    }
}
class ThreadTest3 {
    public static void main(String[] args) {
        Study study = new Study();
        new Thread4(study).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        study.me();
    }
}
class Thread4 extends Thread {
    Study s;

    public Thread4(Study s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.meh();
    }
}
class Study{
    public synchronized void me() {
        System.out.println("进入非同步方法");
    }
    public synchronized void meh() {
        System.out.println("进入同步方法");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步结束");
    }
}

