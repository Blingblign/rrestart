package co;

class Person {
    public static int total;
    static {
        total = 100;
        System.out.println("in static block!");
    }
}
class PersonTest {
    public static void main(String[] args) {
        System.out.println("total = " + Person.total);
        System.out.println("total = " + Person.total);
        int[] arr = {1,2,3};
        System.out.println(arr[2]);
        System.out.println(arr[3]);
    }
}
interface Test3{
     static void getAge(){

    }
}
class TD {
    static int y = 6;

    class Inner {
//         int y = 3;

        void show() {
            System.out.println(y);
            say();
        }
    }
    public void say(){

    }
}

class TC {
    public static void main(String[] args) {
        TD.Inner ti = new TD().new Inner();
        ti.show();
    }
}
interface Test {
    void func();
}

class Demo {
    public static void main(String[] args) {
        // 补足代码；(匿名内部类)
//		new Demo().show(new Test() {
//			public void func() {
//
//			}
//		});
        new Demo().show(new Test(){
            public void func(){

            }
        });

    }

    void show(Test t) {
        t.func();
    }
}
class First {
    private int a;
    static int b = 5;
    public class Contents{
        public int c ;
        public int d;
        public void f(){
            System.out.println(a);
            System.out.println(b);
        }
    }
    static class Titles{
        public int e;
        static int f;

        public void show(){
//            System.out.println(a);
            System.out.println(b);
        }
    }
    public void getInnerClassDate(){
        System.out.println(new Contents().c);//
        System.out.println(new Contents().c);//
        System.out.println(new Titles().e);//
        System.out.println(Titles.f);//
    }
    public static void main(String[] args) {
        First first = new First();
        Contents contents = first.new Contents();
        contents.f();
        Titles titles = new Titles();
        titles.show();
    }

}
interface Bell{
    void sound();
}
class Cellphone{
    public Cellphone() {
    }

    public void alarmClock(Bell bell){
        bell.sound();
    }

    public static void main(String[] args) {
        new Cellphone().alarmClock(new Bell() {
            @Override
            public void sound() {
                System.out.println("起床啦！！！");
            }
        });
    }
}
abstract class Person1{
    int age;
    int height;
    public Person1(int age,int height){
        this.age = age;
        this.height = height;
    }
}
class Student  extends Person1{
    public Student(int age, int height) {
        super(age, height);
    }
//    public Student(int age,int height){
//        this.age = age;
//        this.height = height;
//    }
}
 class Demo2 {
    final int l;
    private static int j = 0;
    private int k = 4;
     {
//         l = 1;
     }
     public Demo2(){
         l =1;
     }
    private static boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = i < 10 || methodB(4);
        b = i < 10 | methodB(8);
    }
    public static void methodC(){
        int i;
    }

    public static void main(String args[]) {
        methodA(0);
        System.out.println(j);
    }
}





