package proxy;

public class DBQuery implements InterfaceDBQuery {
	
	public DBQuery(){
		//数据库连接等耗时操作
	}

	@Override
	public String request() {
		System.out.println("request string");
		return "request string";
	}

}
