/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.service.impl;

import hu.unideb.health.business.calculator.CalculateBMI;
import hu.unideb.health.business.calculator.CalculateBSI;
import hu.unideb.health.business.calculator.CalculateWHtR;
import hu.unideb.health.shared.vo.UserAttributeVO;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author toth
 */
public class CalculatorTest {

    public CalculatorTest() {
    }

    @Test
    public void calculateBMITest() {

        UserAttributeVO userAttributeVO = new UserAttributeVO();
        userAttributeVO.setHeight(200);
        userAttributeVO.setWeight(100);

        Double bmi = CalculateBMI.getInstance().calulateIndex(userAttributeVO);

        assertEquals((double) 25, bmi, 0.01);

        userAttributeVO.setHeight(200);
        userAttributeVO.setWeight(200);

        bmi = CalculateBMI.getInstance().calulateIndex(userAttributeVO);
        assertEquals((double) 50, bmi, 0.01);
    }

    @Test
    public void calculateWHtRTest() {

        UserAttributeVO userAttributeVO = new UserAttributeVO();
        userAttributeVO.setHeight(200);
        userAttributeVO.setWaist(100);

        Double whtr = CalculateWHtR.getInstance().calulateIndex(userAttributeVO);

        assertEquals(0.5, whtr, 0.01);

        userAttributeVO.setHeight(200);
        userAttributeVO.setWaist(200);

        whtr = CalculateWHtR.getInstance().calulateIndex(userAttributeVO);
        assertEquals(1.00, whtr, 0.01);
    }

    @Test
    public void calculateBSITest() {

        UserAttributeVO userAttributeVO = new UserAttributeVO();
        userAttributeVO.setHeight(200);
        userAttributeVO.setWeight(100);
        userAttributeVO.setWaist(100);

        Double bsi = CalculateBSI.getInstance().calulateIndex(userAttributeVO);

        assertEquals(0.03, bsi, 0.01);

        userAttributeVO.setHeight(200);
        userAttributeVO.setWeight(200);
        userAttributeVO.setWaist(100);

        bsi = CalculateBSI.getInstance().calulateIndex(userAttributeVO);
        assertEquals(0.015, bsi, 0.01);
    }
}
