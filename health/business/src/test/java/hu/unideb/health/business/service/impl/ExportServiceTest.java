/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.service.impl;

import com.thoughtworks.xstream.XStream;
import hu.unideb.health.shared.service.ExportService;
import hu.unideb.health.shared.vo.ReportIndexDataVO;
import hu.unideb.health.shared.vo.ReportVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author toth
 */
public class ExportServiceTest {
    
    @Test
    public void exportTest(){
        ReportVO testReport = new ReportVO();
        List<ReportIndexDataVO> dataList = new ArrayList<ReportIndexDataVO>();
        ReportIndexDataVO test = new ReportIndexDataVO();
        test.setBmi(1);
        test.setBsi(2);
        dataList.add(test);
        testReport.setData(dataList);
        testReport.setUsername("my user");
        byte[] result = ExportServiceImpl.getInstance().export(testReport, ExportService.EXPORT_TYPE.XML);
        XStream stream = new XStream();
        ReportVO streamResult = (ReportVO) stream.fromXML(new String(result));
        Assert.assertEquals(streamResult.getUsername(), testReport.getUsername());
    }
    
    
    @Test
    public void exportTest2(){
        ReportVO testReport = new ReportVO();
        List<ReportIndexDataVO> dataList = new ArrayList<ReportIndexDataVO>();
        ReportIndexDataVO test = new ReportIndexDataVO();
        test.setBmi(1);
        test.setWhtr(2);
        test.setCreationDate(new Date());
        dataList.add(test);
        testReport.setData(dataList);
        testReport.setUsername("my user");
        byte[] result = ExportServiceImpl.getInstance().export(testReport, ExportService.EXPORT_TYPE.XML);
        XStream stream = new XStream();
        ReportVO streamResult = (ReportVO) stream.fromXML(new String(result));
        Assert.assertEquals(streamResult.getUsername(), testReport.getUsername());
    }
    
}
