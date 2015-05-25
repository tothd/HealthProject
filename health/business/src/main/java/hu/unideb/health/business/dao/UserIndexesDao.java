package hu.unideb.health.business.dao;

import hu.unideb.health.shared.vo.ReportIndexDataVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import java.util.List;

/**
 * A felhasználó fizikai jellemzői alapján kiszámított indexek adatbázis
 * műveleteit valósítja meg.
 */
public interface UserIndexesDao extends GenericDao<UserIndexesVO> {

    /**
     * Megtalálja az adatbázisban a felhasználó indexeit tartalmazó listát, a
     * felhasználó azonosítója alapján.
     *
     * @param id A felhasználó {@code int} azonosítója.
     * @return A felhasználó indexeit tartalmazó lista.
     */
    List<ReportIndexDataVO> findAllIndexesByUserId(long id);

    /**
     * Megtalálja az adatbázisban a felhasználó indexeit a fizikai paraméterek
     * azonosítója alapján.
     *
     * @param id A paraméterek {@code int} azonosítója.
     * @return A felhasználó indexeit tároló osztály.
     */
    UserIndexesVO findUserIndexesByAttributeId(long id);
}
