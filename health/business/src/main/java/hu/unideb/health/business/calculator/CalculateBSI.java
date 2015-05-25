package hu.unideb.health.business.calculator;

import hu.unideb.health.shared.vo.UserAttributeVO;

public class CalculateBSI implements Calculator {

    private static final CalculateBSI instance = new CalculateBSI();

    private CalculateBSI() {

    }

    public static CalculateBSI getInstance() {
        return instance;
    }

    @Override
    public double calulateIndex(UserAttributeVO userAttributeVO) {
        double bmi = (CalculateBMI.getInstance().calulateIndex(userAttributeVO) / 3) * 2;
        double waist = userAttributeVO.getWaist();
        double height = userAttributeVO.getHeight();

        Double bsiResult = waist / (bmi * height);
        return bsiResult;
    }

}
