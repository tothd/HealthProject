package hu.unideb.health.business.service.impl;

import hu.unideb.health.business.calculator.CalculateBMI;
import hu.unideb.health.business.calculator.CalculateBSI;
import hu.unideb.health.business.calculator.CalculateWHtR;
import hu.unideb.health.business.dao.DaoFactory;
import hu.unideb.health.business.dao.DaoFactory.DAO_TYPE;
import hu.unideb.health.business.dao.GenericDao;
import hu.unideb.health.business.dao.UserAttributeDao;
import hu.unideb.health.business.dao.UserDao;
import hu.unideb.health.business.dao.UserIndexesDao;
import hu.unideb.health.shared.exception.ExistingUserException;
import hu.unideb.health.shared.exception.UserNotFoundException;
import hu.unideb.health.shared.service.UserDataService;
import hu.unideb.health.shared.vo.UserAttributeVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import hu.unideb.health.shared.vo.UserVO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class UserDataServiceImpl implements UserDataService {

    private static final Logger logger = LoggerFactory.getLogger(UserDataServiceImpl.class);
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
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserVO findByNameAndPassword(String name, String password) throws UserNotFoundException {
        if (logger.isDebugEnabled()) {
            logger.debug("User name parameter: " + name);
        }
        try (Connection conn = ConnectionUtil.createConnection();) {
            logger.info("Connection succesfull.");
            UserDao userDao = DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER);
            UserVO userVO = userDao.findByNameAndPassword(name, password);
            if (userVO == null) {
                throw new UserNotFoundException();
            }
            return userVO;
        } catch (SQLException e) {
            logger.info("Connection unsuccesfull.");
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserAttributeVO findUserDataModificationById(Long id) {
        try (Connection conn = ConnectionUtil.createConnection();) {
            logger.info("Connection succesfull.");
            UserAttributeDao userAttributeDao = DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER_ATTRIBUTE);

            UserAttributeVO userAttributeVO = userAttributeDao.findLastByUser(id);
            return userAttributeVO;
        } catch (SQLException ex) {
            logger.info("Connection unsuccesfull.");
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void modifyUserAttribute(UserAttributeVO userAttributeVO) {
        try (Connection conn = ConnectionUtil.createConnection();) {
            logger.info("Connection succesfull.");
            UserAttributeDao userAttributeDao = DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER_ATTRIBUTE);
            userAttributeDao.insert(userAttributeVO);
            conn.commit();
        } catch (SQLException ex) {
            logger.info("Connection unsuccesfull.");
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }

    }

    @Override
    public UserIndexesVO findUserIndexesById(long id) {
        UserIndexesVO userIndexesVO = null;
        try (Connection conn = ConnectionUtil.createConnection();) {
            logger.info("Connection succesfull.");

            UserIndexesDao userIndexesDao = DaoFactory.getInstance().getDao(conn, DAO_TYPE.USER_INDEXES);

            userIndexesVO = userIndexesDao.findUserIndexesByAttributeId(id);

        } catch (SQLException ex) {
            logger.info("Connection unsuccesfull.");
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }

        return userIndexesVO;
    }

}
