package Flyweight;

import java.util.HashMap;
import java.util.Map;

//报表生成类工厂

public class ReportManagerFactory {
	
	Map<String, InterfaceReportManager> financialReportManager = 
			new HashMap<String, InterfaceReportManager>();
	Map<String, InterfaceReportManager> employeeReportManager = 
			new HashMap<String, InterfaceReportManager>();
	
	InterfaceReportManager getFinancialReportManager(String tennatId){
		
		InterfaceReportManager r = financialReportManager.get(tennatId);
		if(null == r){
			r = new FinancialReportManager(tennatId);
			financialReportManager.put(tennatId, r);
		}
		return r;
	}
	
	InterfaceReportManager getEmployeeReportManager(String tennatId){
		
		InterfaceReportManager r = employeeReportManager.get(tennatId);
		if(null == r){
			r = new EmployeeReportManager(tennatId);
			employeeReportManager.put(tennatId, r);
		}
		return r;
	}
	
	public static void main(String[] args){
		ReportManagerFactory rmf = new ReportManagerFactory();
		InterfaceReportManager rm = rmf.getFinancialReportManager("A");
		System.out.println(rm.createReport());
	}
}
