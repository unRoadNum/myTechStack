package proxy;

//使用代理模式实现延迟加载

public class Main {
	
	public static void main(String [] args){
		InterfaceDBQuery q = new DBQueryProxy(); //使用代理
		q.request(); //在真正的使用时才延迟加载
	}
}
