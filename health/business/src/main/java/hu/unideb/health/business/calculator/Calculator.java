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
public interface Calculator {
    
    double calulateIndex(UserAttributeVO userAttributeVO);
    
}
