package hu.unideb.health.business.calculator;

import hu.unideb.health.shared.vo.UserAttributeVO;

/**
 * Kiszámolja a testtömeg-indexet.
 */
public final class CalculateBMI implements Calculator {

    /**
     * Singleton példányt hoz létre.
     */
    private static final CalculateBMI instance = new CalculateBMI();

    /**
     * Privát konstruktor singletonhoz.
     */
    private CalculateBMI() {

    }

    /**
     * Singleton példányt ad vissza.
     *
     * @return Singleton példány.
     */
    public static CalculateBMI getInstance() {
        return instance;
    }

    @Override
    public double calulateIndex(UserAttributeVO userAttributeVO) {
        double weight = userAttributeVO.getWeight();
        double height = userAttributeVO.getHeight();
        Double bmiResult = weight / Math.pow((height / 100), 2);

        return bmiResult;
    }

}
