/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.dao;

import hu.unideb.health.shared.vo.ReportIndexDataVO;
import hu.unideb.health.shared.vo.ReportVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import java.util.List;

/**
 *
 * @author toth
 */
public interface UserIndexesDao extends GenericDao<UserIndexesVO>{
    List<ReportIndexDataVO> findAllIndexesByUserId(long id);
}
