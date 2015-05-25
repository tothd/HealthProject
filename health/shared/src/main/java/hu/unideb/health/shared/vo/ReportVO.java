package hu.unideb.health.shared.vo;

import java.util.List;

/**
 * Megjeleníteni kívánt adatokat tartalmazó osztály. A felhasználó neve és az
 * indexeket, valamint a létrehozásuk dátumát tartalmazó lista.
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
