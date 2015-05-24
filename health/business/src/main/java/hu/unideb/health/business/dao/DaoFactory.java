package hu.unideb.health.business.dao;

import hu.unideb.health.business.dao.impl.UserAttributeDaoImpl;
import hu.unideb.health.business.dao.impl.UserDaoImpl;
import hu.unideb.health.business.dao.impl.UserIndexesDaoImpl;

import java.io.Serializable;
import java.sql.Connection;

public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    public enum DAO_TYPE {

        USER,
        USER_ATTRIBUTE,
        USER_INDEXES,
    };

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public <D extends GenericDao<? extends Serializable>> D getDao(Connection conn, DAO_TYPE type) {
        D result;
        switch (type) {
            case USER: {
                result = (D) new UserDaoImpl(conn);
                break;
            }
            case USER_ATTRIBUTE: {
                result = (D) new UserAttributeDaoImpl(conn);
                break;
            }
            case USER_INDEXES: {
                result = (D) new UserIndexesDaoImpl(conn);
                break;
            }
            default:
                throw new RuntimeException();
        }

        return result;
    }

}
