package hu.unideb.health.shared.service;

import hu.unideb.health.shared.vo.ReportVO;

/**
 * Fájlba exportálást valósítja meg.
 */
public interface ExportService {

    /**
     * Fájl típusa amibe exportálni akarunk.
     */
    enum EXPORT_TYPE {

        XML,
        HTML,
    }

    /**
     * Kiexportálja a felhasználó nevét, az indexeket és azok számításának a
     * dátumát.
     *
     * @param reportVO A fájlban elhelyezni kívánt adatokat tartalmazó osztály.
     * @param export_type Fájl típusa amibe exportálni akarunk.
     * @return Bájttömb a fájl létrehozásához.
     */
    byte[] export(ReportVO reportVO, EXPORT_TYPE export_type);
}
