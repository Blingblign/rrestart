package aa;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BB {
    public static void main(String[] args) {
        try{
            int arr[] = new int[]{1,2};
            System.out.println(arr[3]);
            System.out.println("===");
            int i = 1/0;
            System.out.println("=========1/0");
        }catch(ArithmeticException e){
            System.out.println("算数异常："+e.getMessage());
            e.printStackTrace();
        }catch (IndexOutOfBoundsException e){
            System.out.println("角标越界异常："+e.getMessage());
            e.printStackTrace();

        }
        finally {
            System.out.println("ok!");
        }
//        int y = 1 + i++;
        int y =1;
        System.out.println(y);

    }
}
class A {
    public void methodA() throws IOException {
//        throw new String("want to throw");;
    } }
class B1 extends A {
    public void methodA() throws FileNotFoundException {
        throw new FileNotFoundException();
    } }
class B2 extends A {
    public void methodA() throws IOException { //报错
    } }

class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        }finally {
            System.out.println("用A方法的finally");
        }
    }
    static void methodB() {
        try {
            System.out.println("进入方法B");
            return;
        } finally {
            System.out.println("调用B方法的finally");
        }
    }
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());}
        methodB();
    }
}

