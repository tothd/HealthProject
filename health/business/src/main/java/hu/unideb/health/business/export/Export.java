/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.export;

import hu.unideb.health.shared.vo.ReportVO;

/**
 *
 * @author toth
 */
public interface Export {
    byte[] export(ReportVO reportVO);
}
