package aa;


import java.util.ArrayList;

class Test2{

    public static void main(String[] args) {
        Object o = new Test2();
        String s = "aa";
        System.out.println("测试：这是第一次在Github上的改动...");


        s.charAt(2);
        System.out.println(o.toString());
        int[] arr ={1,1,1,1};
        try {
            for(int i = 0 ; i < 5;i++){
                System.out.println(arr[i]);
            }
        } catch (Exception e) {
            System.out.println("这是个异常，不是错误");
        }

    }
}

public class AA {
    public static void main(String[] args) {
        int test = test(3,5);
        System.out.println(test);
    }

    public static int test(int x, int y) {
        int result = x;
        try {
            if (x<0 || y<0) {

                return 0;
            }
            result = x + y;
            return result;
        } finally {
            result = x - y;
        }
    }

}
class Test {
    static int x, y, z;

    static {
        int x = 5;
        x--;
    }

    static {
        x--;
    }

    public static void main(String[] args) {
        System.out.println("x=" + x);//-1
        z--;//-1
        method();//y=-1,z=1还是0？错误
        System.out.println("result:" + (z + y + ++z));
    }

    public static void method() {
        y = z++ + ++z;
        System.out.println("z="+z+"y="+y);
    }
}
class Demo {
    public static void func() {
        try {
            throw new Exception();
//            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        try {
            func();
        } catch (Exception e) {
            System.out.println("C");
        }
        System.out.println("D");
    }
}
class Exc0 extends Exception {
}

class Exc1 extends Exc0 {
}

class AAB {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("用A方法的finally");
        }
    }

    static int methodB() {
        try {
            System.out.println("进入方法B");
//             throw new Exception();
            return 1;
        } catch (Exception e) {
            return 3;
        } finally {
            System.out.println("调用B方法的finally");
             return 2;
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int i = methodB();
        System.out.println(i);
    }
}
class MyThread extends Thread {
    private String whoAmI;
    private int delay;

    public MyThread(String s, int d) {
        whoAmI = s;
        delay = d;
    }

    public void run() {
        try {
            sleep(delay);
        } catch (InterruptedException ie) {
        }
        System.out.println("Hello!I am" + whoAmI + ",I slept" + delay + "milliseconds");
    }
}

class TestThread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-a", (int) (Math.random() * 100));
        MyThread t2 = new MyThread("Thread-b", (int) (Math.random() * 100));
        MyThread t3 = new MyThread("Thread-c", (int) (Math.random() * 100));
        t1.start();
        t2.start();
        t3.start();
        System.out.println("t3 = " + t3.getName());
    }
}

/**
 * 玩具-馒头题
 */
class ToyCase {
     int product;
     int food;
    public synchronized void setProduct() {
        notify();
        if(product < 20) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产玩具数量为"+ ++product);

        }
        else if (food == 3) {
            try {
                Thread.sleep(200);
                System.out.println("生产玩具数量为"+ ++product);
                food = 0;//将food值重置
//                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public synchronized void setFood() {
        notify();
        //当产品数量<20,当前线程等待
        if (product < 20) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 3; i++) {
            //每秒吃一个馒头
            try {
                Thread.sleep(1000);
                System.out.println("吃了"+ ++food +"个馒头");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class ThreadTest2 {
    public static void main(String[] args) {
        ToyCase toyCase = new ToyCase();
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    if (toyCase.product < 50)
                        toyCase.setProduct();
                    else break;
                }
                System.out.println("结束生产");

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    if (toyCase.product < 50)
                        toyCase.setFood();
                    else break;
                }
                System.out.println("结束吃饭饭");

            }
        }.start();

    }
}



