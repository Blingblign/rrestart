package co;

class Father {
	public static int i = 1;
	static {
		System.out.println("i="+i);
		i = 2;
		System.out.println("i="+i);
	}
	{
		System.out.println("Father");
		i = 3;
	}

	public Father() {
		System.out.println("33333333333");
		i = 4;

	}
	public Integer getAge(){
		return new Integer(0);
	}

}
class Something {
	public static void main(String[] args) {
		Other o = new Other();
		new Something().addOne(o);
	}
	public void addOne(final Other o) {
// o = new Other();
		o.i++;
	}
}
class Other {
	public int i;
}


public class Son extends Father {
	static {
		System.out.println("44444444444");
		i =5;
	}
	{
		System.out.println("55555555555");
		i =6;
	}
	public Son() {
		System.out.println("66666666666");
	}
	public Integer getAge(){
		return 0;
	}


	public static void main(String[] args) { // 由父及子 静态先行
		System.out.println("77777777777");//1,4,7
		System.out.println("************************");
		new Son();//2,3,5,6
		System.out.println("************************");

		new Son();//2,3,5,6
		System.out.println("************************");
		new Father();//2,3
	}

}
