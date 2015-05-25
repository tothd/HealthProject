package hu.unideb.health.shared.service;

import hu.unideb.health.shared.vo.ReportVO;

/**
 * Megjeleníteni kívánt adatokhoz szükséges műveletek megvalósítása.
 */
public interface ReportService {

    /**
     * Megtalálja az adatbázisban a felhasználó megjeleníteni kívánt adatait a
     * felhasználó azonosítója alapján.
     *
     * @param id A felhasználó azonosítója.
     * @return A felhasználó megjeleníteni kívánt adatai.
     */
    ReportVO findAllIndexesByUserId(long id);
}
