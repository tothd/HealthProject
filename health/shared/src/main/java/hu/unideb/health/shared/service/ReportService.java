package hu.unideb.health.shared.service;

import hu.unideb.health.shared.vo.ReportVO;

/**
 * 
 * @author toth
 */
public interface ReportService {
            
    /**
     * 
     * @param id
     * @return 
     */    
    ReportVO findAllIndexesByUserId(long id);
}
