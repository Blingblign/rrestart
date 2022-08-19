package homework;

import jdk.nashorn.internal.ir.CaseNode;

/**
 * A线程打印A
 * B线程打印B
 * C线程打印C
 * 交替打印ABCABC...打印100个字符
 */
public class ThreadPrintTest {
    private static int index;
    public static void main(String[] args) {
        if (index < 1) {
            index ++;
            System.out.println(index);
        }
//        Print print = new Print();
//        PrintThread threadA = new PrintThread(print, 1);
//        PrintThread threadB = new PrintThread(print, 2);
//        PrintThread threadC = new PrintThread(print, 3);
//        threadA.setName("A");
//        threadB.setName("B");
//        threadC.setName("C");
//        threadA.start();
//        threadB.start();
//        threadC.start();

    }
}
class PrintThread extends Thread {
    private Print print;
    private int i;//标识符
    public PrintThread(Print print,int i) {
        this.print = print;
        this.i = i;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (print) {
                if (print.count >= 100) break;
                print.methodA(i);
            }

        }
    }
}
class Print{
    int count;//打印次数
    int flag = 1;//标识符，1--A打印 2--B打印 3--C打印
    public void methodA(int i) {
        if (flag != i) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            switch (i) {
                case 1:
                    System.out.println(Thread.currentThread().getName()+"：打印A");
                    break;
                case 2:
                    System.out.println(Thread.currentThread().getName()+"：打印B");
                    break;
                case 3:
                    System.out.println(Thread.currentThread().getName()+"：打印C");
            }
            count++;
            flag = (++i != 4) ? i : 1;
            notifyAll();
        }
    }
//    public synchronized void methodB() {
//        if (flag != 2) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }else {
//            System.out.println(Thread.currentThread().getName()+"：打印B");
//            count++;
//            flag = 3;
//            notifyAll();
//        }
//    }
//    public synchronized void methodC() {
//        if (flag != 3) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }else {
//            System.out.println(Thread.currentThread().getName()+"：打印C");
//            count++;
//            flag = 1;
//            notifyAll();
//        }
//    }
}
class ThreadTest2 {
    private static int count;//打印次数
    private static final Object lock= new Object();//锁

    public static void main(String[] args) {
        new Thread(() -> {
            while (count != 100) {
                synchronized (lock) {
                    if(count+1 <= 100 && count%3 == 0){
                        System.out.println("A");
                        count++;
                        lock.notifyAll();
                        try {
                            if(count < 100) lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
        new Thread(() -> {
            while (count != 100) {
                synchronized (lock) {
                    if(count+1 <= 100 && count%3 == 1){
                        System.out.println("B");
                        count++;
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
        new Thread(() -> {
            while (count != 100) {
                synchronized (lock) {
                    if(count+1 <= 100 && count%3 == 2 ){
                        System.out.println("C");
                        count++;
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
}

