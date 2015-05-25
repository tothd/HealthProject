package hu.unideb.health.business.calculator;

import hu.unideb.health.shared.vo.UserAttributeVO;

/**
 * Kiszámolja a derék-magasság arányt.
 */
public final class CalculateWHtR implements Calculator {

    /**
     * Singleton példányt hoz létre.
     */
    private static final CalculateWHtR instance = new CalculateWHtR();

    /**
     * Privát konstruktor singletonhoz.
     */
    private CalculateWHtR() {

    }

    /**
     * Singleton példányt ad vissza.
     *
     * @return Singleton példány.
     */
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
