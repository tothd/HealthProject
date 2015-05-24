package hu.unideb.health.business.service.impl;

import hu.unideb.health.shared.service.ExportService;
import hu.unideb.health.shared.service.ReportService;
import hu.unideb.health.shared.service.UserDataService;

public class ServiceLocator {
	
	public static UserDataService getUserDataService(){
		return UserDataServiceImpl.getInstance();
	}

        public static ReportService getReportService(){
		return ReportServiceImpl.getInstance();
	}
        
        public static ExportService getExportService(){
		return ExportServiceImpl.getInstance();
	}
}
