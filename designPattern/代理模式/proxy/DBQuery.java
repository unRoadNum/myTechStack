package proxy;

public class DBQuery implements InterfaceDBQuery {
	
	public DBQuery(){
		//���ݿ����ӵȺ�ʱ����
	}

	@Override
	public String request() {
		System.out.println("request string");
		return "request string";
	}

}
