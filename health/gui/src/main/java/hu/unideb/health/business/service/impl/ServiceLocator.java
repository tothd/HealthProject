package hu.unideb.health.business.service.impl;

import hu.unideb.health.shared.service.ExportService;
import hu.unideb.health.shared.service.ReportService;
import hu.unideb.health.shared.service.UserDataService;

/**
 * A felhasználói felület által láthathó szolgáltatások.
 */
public class ServiceLocator {

    /**
     * A felhasználóhoz kapcsolódó szolgáltatások.
     *
     * @return Felhasználó szolgáltatásait megvalósító osztály.
     */
    public static UserDataService getUserDataService() {
        return UserDataServiceImpl.getInstance();
    }

    /**
     * A megjelenítéshez tartozó adatokkal foglalkozó
     * szolgáltatások.
     *
     * @return Megjelenítést megvalósító szolgáltatás.
     */
    public static ReportService getReportService() {
        return ReportServiceImpl.getInstance();
    }

    /**
     * Exportálni kívánt adatokkal 
     * @return Exportálást megvalósító szolgáltatás.
     */
    public static ExportService getExportService() {
        return ExportServiceImpl.getInstance();
    }
}
