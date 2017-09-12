package proxy;

public class DBQueryProxy implements InterfaceDBQuery {
	
	private DBQuery real = null;
	
	@Override
	public String request() {
		if(null == real){
			real = new DBQuery();
		}
		return real.request();
	}

}
