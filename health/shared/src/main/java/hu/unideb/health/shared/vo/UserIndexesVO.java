package hu.unideb.health.shared.vo;

import java.io.Serializable;

/**
 * Az indexeket és a fizikai jellemzőek azonosítóját tartalmazó osztály.
 */
public class UserIndexesVO implements Serializable {

    private long userAttributeId;
    private double bmi;
    private double bsi;
    private double whtr;

    public long getUserAttributeId() {
        return userAttributeId;
    }

    public void setUserAttributeId(long userAttributeId) {
        this.userAttributeId = userAttributeId;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBsi() {
        return bsi;
    }

    public void setBsi(double bsi) {
        this.bsi = bsi;
    }

    public double getWhtr() {
        return whtr;
    }

    public void setWhtr(double whtr) {
        this.whtr = whtr;
    }

}
