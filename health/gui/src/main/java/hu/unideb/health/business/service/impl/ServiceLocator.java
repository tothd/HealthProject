package hu.unideb.health.business.service.impl;

import hu.unideb.health.shared.service.UserDataService;

public class ServiceLocator {
	
	public static UserDataService getUserDataService(){
		return UserDataServiceImpl.getInstance();
	}

}
