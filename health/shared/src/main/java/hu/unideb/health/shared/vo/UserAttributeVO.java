package hu.unideb.health.shared.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * A felhasználó fizikai jellemzőit tartalmazó osztály.
 */
public class UserAttributeVO implements Serializable {

    private int height;
    private int weight;
    private int waist;
    private Date creationDate;
    private long userId;
    private String gender;
    private Date birthDate;
    private long userAttributeId;

    public Date getBirthDate() {
        return birthDate;
    }

    public long getUserAttributeId() {
        return userAttributeId;
    }

    public void setUserAttributeId(long userAttributeId) {
        this.userAttributeId = userAttributeId;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
