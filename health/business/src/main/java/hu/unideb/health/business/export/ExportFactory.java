/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.export;

import hu.unideb.health.shared.service.ExportService.EXPORT_TYPE;

/**
 *
 * @author toth
 */
public class ExportFactory {
    private static final ExportFactory instance = new ExportFactory();
    
    private ExportFactory(){
        
    }
    
    public static ExportFactory getInstance() {
        return instance;
    }
    
    public Export getExportImplementation(EXPORT_TYPE export_type){
        Export export;
        switch(export_type){
            case XML: {
                export = XMLExport.getInstance();
                break;
            }
            case HTML: {
                throw new RuntimeException();
            }
            default:
                throw new RuntimeException();
        }
        
        return export;
    }
}
