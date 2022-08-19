package com.company;

//import org.junit.Test;

public class Parent {
    public static void main(String[] args) {
//        Parent parent = new Parent();
//        System.out.println(parent);//com.company.Parent@14ae5a5
        Children children = new Children();
        System.out.println(children);//com.company.Children@7f31245a
        children.make();//a为：com.company.Children@6d6f6e28
       // children.make();//a为：com.company.Children@135fbaa4
        String i1 = "abc";
        String i2 = "abc";
        System.out.println("jieguo:"+i1 == i2);
        Double d1 = 5.6;
        Double d2 = 5.6;
        Integer a1 = 128;
        int a2 =128;
        System.out.println(d1 == d2);
        System.out.println("a1,a2"+(a1 == a2));
        System.out.println("==========");


    }
    private int show(int a,int b){
        return 0;
    }
}
class Children extends Parent{

    public void make(){
        Parent parent = new Parent();
        System.out.println(parent);
        Children a = new Children();
        System.out.println("a为："+a);
    }
    public int show(int a,int b){
        return 0;
    }

}



class Test {

    public static void main(String[] args) {
        Base b1 = new Base();
        Base b2 = new Sub();
    }
}
class Base{
    Base(){
        method(100);
    }
    public void method(int i){
        System.out.println("base : " + i);
    }
}
class Sub extends Base{
    Sub(){
        super.method(70);
    }
    public void method(int j){
        System.out.println("sub : " + j);
    }
}

class A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

class B extends A {
    private int a;

//    public void setA(int a) {
//        this.a = a;
//    }
     public int getA(){
     return a;
     }
}

class PersonTest {

    public static void main(String[] args) {
        A c = new B();

        c.setA(5);

        System.out.println(c.getA());
    }
}

class Something {
    public static void main(String[] something_to_do) {
        System.out.println("Do something ...");
    }
}

class Fu {
    boolean show(char a) {
        System.out.println(a);
        return true;
    }
}

class Demo extends Fu {
    public static void main(String[] args) {
        int i = 0;
        Fu f = new Demo();
        Demo d = new Demo();
        for (f.show('A'); f.show('B') && (i < 2); f.show('C')) {
            i++;
            d.show('D');
        }
    }

    boolean show(char a) {
        System.out.println(a);
        return false;
    }
}












