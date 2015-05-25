package hu.unideb.health.business.dao;

import java.sql.SQLException;
import hu.unideb.health.shared.vo.UserVO;

/**
 * A felhasználó adatainak az adatbázis műveleteit valósítja meg.
 */
public interface UserDao extends GenericDao<UserVO> {

    /**
     * Megtalálja a felhasználót neve és jelszava alapján.
     *
     * @param name Felhasználó {@code String} neve.
     * @param password Felhasználó jelszava.
     * @return Felhasználó adatai.
     * @throws SQLException Adatbázisban fellépő hiba.
     */
    UserVO findByNameAndPassword(String name, String password)
            throws SQLException;

    /**
     * Megtalálja a felhasználót az azonosítója alpján.
     *
     * @param id Felhasználó {@code int} azonosítója.
     * @return Felhasználó adatai.
     * @throws SQLException Adatbázisban fellépő hiba.
     */
    UserVO findById(Long id) throws SQLException;

}
