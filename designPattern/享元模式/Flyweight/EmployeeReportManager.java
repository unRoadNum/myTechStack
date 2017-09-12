package Flyweight;

//员工报表

public class EmployeeReportManager implements InterfaceReportManager {
	
	protected String tennatId = null;
	public EmployeeReportManager(String tennatId){
		this.tennatId = tennatId;
	}
	@Override
	public String createReport() {
		System.out.println("This is a employee report!");
		return "This is a employee report!";
	}

}
