package hu.unideb.health.business.export;

import hu.unideb.health.shared.service.ExportService.EXPORT_TYPE;

/**
 * Fájlba exportálást megvalósító osztályt létrehozó osztály.
 */
public class ExportFactory {

    private static final ExportFactory instance = new ExportFactory();

    private ExportFactory() {

    }

    public static ExportFactory getInstance() {
        return instance;
    }

    /**
     * Visszaadja az exportálást megvalósító osztályt.
     *
     * @param export_type Amibe szertnénk exportálni.
     * @return exportálást megvalósító osztály.
     */
    public Export getExportImplementation(EXPORT_TYPE export_type) {
        Export export = null;
        switch (export_type) {
            case XML: {
                export = XMLExport.getInstance();
                break;
            }
        }

        return export;
    }
}
