/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.service.impl;

import hu.unideb.health.business.export.Export;
import hu.unideb.health.business.export.ExportFactory;
import hu.unideb.health.business.export.XMLExport;
import hu.unideb.health.shared.service.ExportService;
import hu.unideb.health.shared.vo.ReportVO;

/**
 *
 * @author toth
 */
public class ExportServiceImpl implements ExportService{
    
    private static final ExportServiceImpl instance = new ExportServiceImpl();
    
    private ExportServiceImpl(){
        
    }
    
    public static ExportServiceImpl getInstance() {
        return instance;
    }

    @Override
    public byte[] export(ReportVO reportVO, EXPORT_TYPE export_type) {
        Export export = ExportFactory.getInstance().getExportImplementation(export_type);
        
        return XMLExport.getInstance().export(reportVO);
    }
    
}
