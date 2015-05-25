package hu.unideb.health.business.service.impl;

import hu.unideb.health.business.export.Export;
import hu.unideb.health.business.export.ExportFactory;
import hu.unideb.health.business.export.XMLExport;
import hu.unideb.health.shared.service.ExportService;
import hu.unideb.health.shared.vo.ReportVO;

/**
 * Exportolást implementáló osztály.
 */
public class ExportServiceImpl implements ExportService {

    /**
     * Singleton példányt hoz létre.
     */
    private static final ExportServiceImpl instance = new ExportServiceImpl();

    /**
     * Privát konstruktor singletonhoz.
     */
    private ExportServiceImpl() {

    }

    /**
     * Singleton példányt ad vissza.
     *
     * @return Singleton példány.
     */
    public static ExportServiceImpl getInstance() {
        return instance;
    }

    @Override
    public byte[] export(ReportVO reportVO, EXPORT_TYPE export_type) {
        Export export = ExportFactory.getInstance().getExportImplementation(export_type);

        return XMLExport.getInstance().export(reportVO);
    }

}
