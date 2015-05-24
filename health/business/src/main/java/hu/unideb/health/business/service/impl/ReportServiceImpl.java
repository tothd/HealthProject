/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.service.impl;

import hu.unideb.health.business.dao.DaoFactory;
import hu.unideb.health.business.dao.UserDao;
import hu.unideb.health.business.dao.UserIndexesDao;
import hu.unideb.health.shared.service.ReportService;
import hu.unideb.health.shared.vo.ReportVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import hu.unideb.health.shared.vo.UserVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toth
 */
public class ReportServiceImpl implements ReportService{

    private static final Logger logger=LoggerFactory.getLogger(ReportServiceImpl.class);
    
    private static final ReportServiceImpl instance = new ReportServiceImpl();

    public static ReportServiceImpl getInstance() {
        return instance;
    }
    
    @Override
    public ReportVO findAllIndexesByUserId(long id) {
        if(logger.isDebugEnabled()){
            logger.debug("User id parameter: "+id);
        }
        ReportVO reportVO=new ReportVO();
        try(Connection conn=ConnectionUtil.createConnection();){
            UserIndexesDao userIndexesDao=DaoFactory.getInstance().getDao(conn, DaoFactory.DAO_TYPE.USER_INDEXES);
            reportVO.setData(userIndexesDao.findAllIndexesByUserId(id));
            
            UserDao userDao=DaoFactory.getInstance().getDao(conn, DaoFactory.DAO_TYPE.USER);
            UserVO userVO = userDao.findById(id);
            
            reportVO.setUsername(userVO.getName());
            
        } catch (SQLException ex) {
            logger.error(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        }
        return reportVO;
    }
    
}
