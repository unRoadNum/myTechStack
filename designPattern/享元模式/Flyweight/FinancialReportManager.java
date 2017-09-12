package Flyweight;

//Ա���������뱨��

public class FinancialReportManager implements InterfaceReportManager {
	
	protected String tenantId = null;
	public FinancialReportManager(String tenantId){
		this.tenantId = tenantId;
	}
	@Override
	public String createReport() {
		System.out.println("This is a financial report!");
		return "This is a financial report!";
	}

}
