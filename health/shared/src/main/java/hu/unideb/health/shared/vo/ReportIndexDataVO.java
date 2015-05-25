package hu.unideb.health.shared.vo;

import java.util.Date;

/**
 *Az indexeket és létrehozásuk dátumát tartalmazó osztály.
 */
public class ReportIndexDataVO extends UserIndexesVO{
    private Date creationDate;

    /**
     * Visszaadja a létrehozás dátumát.
     * @return Létrehozás dáruma.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    
    
}
