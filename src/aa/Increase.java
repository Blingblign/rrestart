package aa;

import java.text.BreakIterator;

/**
 * 创建两个自增、自减线程对i各操作20次
 */
public class Increase {
    static int i;
    public static void main(String[] args) {
        new Thread() {
            int j;
            @Override
            public void run() {
                while (true) {
                    if (j >= 20) {
                        break;
                    }
                    synchronized (Increase.class) {
                        i++;
                        System.out.println("自增："+i);
                        j++;
                    }
                }
            }
        }.start();
        new Thread(){
            int  j;
            @Override
            public void run() {
                while (true) {
                    if (j >= 20) break;
                    synchronized (Increase.class) {
                        i--;
                        System.out.println("自减："+i);
                        j++;
                    }
                }

            }
        }.start();
    }
}
