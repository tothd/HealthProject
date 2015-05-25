package hu.unideb.health.business.calculator;

import hu.unideb.health.shared.vo.UserAttributeVO;

public class CalculateWHtR implements Calculator {

    private static final CalculateWHtR instance = new CalculateWHtR();

    private CalculateWHtR() {

    }

    public static CalculateWHtR getInstance() {
        return instance;
    }

    @Override
    public double calulateIndex(UserAttributeVO userAttributeVO) {
        double waist = userAttributeVO.getWaist();
        double height = userAttributeVO.getHeight();

        return waist / height;
    }

}
