package hu.unideb.health.shared.service;

import hu.unideb.health.shared.exception.ExistingUserException;
import hu.unideb.health.shared.exception.UserNotFoundException;
import hu.unideb.health.shared.vo.UserAttributeVO;
import hu.unideb.health.shared.vo.UserVO;

public interface UserDataService {
	
	UserVO createUser(UserVO user, UserAttributeVO userAttribute) throws ExistingUserException;
	
	UserVO findByNameAndPassword(String name, String password) throws UserNotFoundException;
        
        UserAttributeVO findUserDataModificationById(Long id);
        
        void modifyUserAttribute(UserAttributeVO userAttributeVO);
        

}
