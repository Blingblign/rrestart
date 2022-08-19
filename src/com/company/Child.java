package com.company;

import java.util.Objects;

class Child extends Parent{ //设父类和子类在同一个包内
    private int c1 = 21;
    public int c2 = 22;
    private void cm1(){System.out.println("in cm1() c1=" + c1);}
    public void cm2(){System.out.println("in cm2() c2=" + c2);}

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return c1 == child.c1 && c2 == child.c2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c1, c2);
    }

    public static void main(String[] args){

    }
}

