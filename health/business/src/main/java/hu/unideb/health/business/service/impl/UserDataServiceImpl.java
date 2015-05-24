package hu.unideb.health.business.service.impl;

import hu.unideb.health.business.dao.DaoFactory;
import hu.unideb.health.business.dao.DaoFactory.DAO_TYPE;
import hu.unideb.health.business.dao.UserAttributeDao;
import hu.unideb.health.business.dao.UserDao;
import hu.unideb.health.shared.exception.ExistingUserException;
import hu.unideb.health.shared.exception.UserNotFoundException;
import hu.unideb.health.shared.service.UserDataService;
import hu.unideb.health.shared.vo.UserAttributeVO;
import hu.unideb.health.shared.vo.UserVO;
import java.sql.Connection;
import java.sql.SQLException;

class UserDataServiceImpl implements UserDataService {

    private static final UserDataServiceImpl instance = new UserDataServiceImpl();

    public static UserDataServiceImpl getInstance() {
        return instance;
    }

    @Override
    public UserVO createUser(UserVO user, UserAttributeVO userAttribute) throws ExistingUserException {
        try (Connection conn = ConnectionUtil.createConnection();) {
            UserDao userDao = DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER);
            userDao.insert(user);
            UserVO result = userDao.findByNameAndPassword(user.getName(), user.getPassword());
            userAttribute.setUserId(result.getId());
            UserAttributeDao userAttributeDao = DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER_ATTRIBUTE);
            userAttributeDao.insert(userAttribute);
            conn.commit();
            return result;

        } catch (SQLException e) {
            //TODO log
            throw new RuntimeException(e);
        } 
    }

    @Override
    public UserVO findByNameAndPassword(String name, String password) throws UserNotFoundException {
        try (Connection conn = ConnectionUtil.createConnection();) {
            UserDao userDao = DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER);
            UserVO userVO = userDao.findByNameAndPassword(name, password);
            if (userVO == null) {
                throw new UserNotFoundException();
            }
            return userVO;
        } catch (SQLException e) {
            //TODO log
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserAttributeVO findUserDataModificationById(Long id) {
        try (Connection conn=ConnectionUtil.createConnection();){
            UserAttributeDao userAttributeDao=DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER_ATTRIBUTE);
            
            UserAttributeVO userAttributeVO=userAttributeDao.findLastByUser(id);
            return userAttributeVO;
        } catch (SQLException ex) {
            
            throw new RuntimeException(ex);
        }
        
    }

    @Override
    public void modifyUserAttribute(UserAttributeVO userAttributeVO) {
        try(Connection conn=ConnectionUtil.createConnection();){
            UserAttributeDao userAttributeDao=DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER_ATTRIBUTE);
            userAttributeDao.insert(userAttributeVO);
            conn.commit();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
                
        
        
    }

}
