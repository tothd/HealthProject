/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.shared.vo;

import java.util.List;

/**
 *
 * @author toth
 */
public class ReportVO {
    
    private String username;
    private List<ReportIndexDataVO> data;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ReportIndexDataVO> getData() {
        return data;
    }

    public void setData(List<ReportIndexDataVO> data) {
        this.data = data;
    }
    
    
}
