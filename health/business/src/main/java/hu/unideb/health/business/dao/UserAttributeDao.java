package hu.unideb.health.business.dao;

import hu.unideb.health.shared.vo.UserAttributeVO;
import java.sql.SQLException;

/**
 * A felhasználó fizikia jellemzőinek az adatbázis műveleteit valósítja meg.
 */
public interface UserAttributeDao extends GenericDao<UserAttributeVO> {

    /**
     * Az adatbázisban utoljára felvett fizikai jellemzőket adja vissza a
     * felhasználó azonosítója alapján.
     *
     * @param id A felhasználó {@code int} azonosítója.
     * @return A felhasználó fizikai jellemzői.
     * @throws SQLException Adatbázisban fellépő hiba.
     */
    UserAttributeVO findLastByUser(long id) throws SQLException;

}
