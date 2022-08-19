package com.company;

public class re2 {
}
interface A1 {
    int x = 0;
}
class B1 {
    int x = 1;
}
class C extends B1 implements A1 {
    public void pX() {
        System.out.println(A1.x);
    }
    public static void main(String[] args) {
        new C().pX();
    }
}

interface Filial {// 孝顺的
    default void help() {
        System.out.println("老妈，我来救你了");
    }
}
class Spoony {// 痴情的
    void help() {
        System.out.println("媳妇，别怕，我来了");
    }
}

class Man extends Spoony implements Filial {
    @Override
    public void help() {
        System.out.println("我该怎么办呢？");
        Filial.super.help();
        super.help();
    }
}
class Outer {
    private int s = 111;
    public class Inner {
        private int s = 222;
        public void mb(int s) {
            System.out.println(s); // 局部变量s
            System.out.println(this.s); // 内部类对象的属性s
            System.out.println(Outer.this.s); // 外部类对象属性s
        }
    }
    public static void main(String args[]) {
        Outer a = new Outer();
        Outer.Inner b = a.new Inner();
        b.mb(333);
    }
}


