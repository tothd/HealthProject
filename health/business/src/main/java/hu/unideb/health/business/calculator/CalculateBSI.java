package hu.unideb.health.business.calculator;

import hu.unideb.health.shared.vo.UserAttributeVO;

/**
 * Kiszámolja a testforma-indexet.
 */
public final class CalculateBSI implements Calculator {
    
    /**
     * Singleton példányt hoz létre.
     */
    private static final CalculateBSI instance = new CalculateBSI();
    
    /**
     * Privát konstruktor singletonhoz.
     */
    private CalculateBSI() {

    }

    /**
     * Singleton példányt ad vissza.
     *
     * @return Singleton példány.
     */
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
