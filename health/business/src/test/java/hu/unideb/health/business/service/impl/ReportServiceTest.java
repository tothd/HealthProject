package hu.unideb.health.business.service.impl;

import hu.unideb.health.shared.vo.ReportIndexDataVO;
import hu.unideb.health.shared.vo.ReportVO;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author toth
 */
public class ReportServiceTest {
    
    
    public void reportTest(){
        ReportVO testReport = new ReportVO();
        List<ReportIndexDataVO> dataList = new ArrayList<ReportIndexDataVO>();
        ReportIndexDataVO test = new ReportIndexDataVO();
        test.setBmi(1);
        test.setBsi(2);
        dataList.add(test);
        testReport.setData(dataList);
        testReport.setUsername("my user");
        
        ReportVO testResult = ReportServiceImpl.getInstance().findAllIndexesByUserId(2);
        Assert.assertEquals(testReport.getUsername(),testResult.getUsername());
    }

}
