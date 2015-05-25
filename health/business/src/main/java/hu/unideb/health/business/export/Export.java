package hu.unideb.health.business.export;

import hu.unideb.health.shared.vo.ReportVO;

/**
 * Az adatok fájlba való exportálása.
 */
public interface Export {

    /**
     * Kiexportálja a felhasználó nevét, az indexeket és azok számításának a
     * dátumát.
     *
     * @param reportVO A fájlban elhelyezni kívánt adatokat tartalmazó osztály.
     * @return Bájttömb a fájl létrehozásához.
     */
    byte[] export(ReportVO reportVO);
}
