/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.shared.service;

import hu.unideb.health.shared.vo.ReportVO;

/**
 *
 * @author toth
 */
public interface ExportService {
    enum EXPORT_TYPE{
        XML,
        HTML,
    }
    
    byte[] export(ReportVO reportVO,EXPORT_TYPE export_type);
}
