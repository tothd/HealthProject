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
public class CalculateBMI implements Calculator{
    
    private static final CalculateBMI instance=new CalculateBMI();
    
    private CalculateBMI(){
        
    }

    public static CalculateBMI getInstance() {
        return instance;
    }
    
    

    @Override
    public double calulateIndex(UserAttributeVO userAttributeVO) {
       double weight=userAttributeVO.getWeight();
       double height=userAttributeVO.getHeight();
       Double bmiResult=weight/Math.pow((height/100), 2);
            
       return bmiResult;
    }
    
}