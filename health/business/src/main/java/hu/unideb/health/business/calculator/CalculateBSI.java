/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.calculator;

import hu.unideb.health.shared.vo.UserAttributeVO;

/**
 *
 * @author toth
 */
public class CalculateBSI implements Calculator{

    private static final CalculateBSI instance=new CalculateBSI();
    
    private CalculateBSI(){
        
    }

    public static CalculateBSI getInstance() {
        return instance;
    }
    
    @Override
    public double calulateIndex(UserAttributeVO userAttributeVO) {
        double bmi=(CalculateBMI.getInstance().calulateIndex(userAttributeVO)/3)*2;
        double waist=userAttributeVO.getWaist();
        double height=userAttributeVO.getHeight();
        
        Double bsiResult=waist/(bmi*height);
        return bsiResult;
    }
    
}
