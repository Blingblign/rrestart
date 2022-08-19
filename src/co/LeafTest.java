package co;
class Root{
	static int i = 1;
	int j = 3;
	static{
		System.out.println("Root的静态初始化块");
		System.out.println("i="+i);
		i = 2;
	}
	{
		System.out.println("Root的普通初始化块");
		i = 3;
		System.out.println("i="+i);
		System.out.println("j="+j);

	}
	public Root(){
		System.out.println("Root的无参数的构造器");
		System.out.println("i="+i);
		i = 4;
		System.out.println("i="+i);
	}
}
class Mid extends Root{
	static{
		System.out.println("Mid的静态初始化块");
	}
	{
		System.out.println("Mid的普通初始化块");
	}
	public Mid(){
		System.out.println("Mid的无参数的构造器");
	}
	public Mid(String msg){
		//通过this调用同一类中重载的构造器
		this();
		System.out.println("Mid的带参数构造器，其参数值："
			+ msg);
	}
}
class Leaf extends Mid{
	static{
		System.out.println("Leaf的静态初始化块");
	}
	{
		System.out.println("Leaf的普通初始化块");
	}	
	public Leaf(){
		//通过super调用父类中有一个字符串参数的构造器
		super("尚硅谷");
		System.out.println("Leaf的构造器");
	}
}
public class LeafTest{
	public static void main(String[] args){
		new Leaf(); //Leaf的静态初始化块 Leaf的普通初始化块 Mid的静态初始化块 Mid的普通初始化块 msg ="尚硅谷" Root的静态初始化块 Root的普通初始化块 Root的无参数的构造器 Mid的无参数的构造器
		//Mid的带参数构造器，其参数值：尚硅谷 Leaf的构造器
		new Leaf();
	}
}

