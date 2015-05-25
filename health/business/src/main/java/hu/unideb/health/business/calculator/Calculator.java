package hu.unideb.health.business.calculator;

import hu.unideb.health.shared.vo.UserAttributeVO;

/**
 * Indexek számítását valósítja meg fizikai jellemzőkből.
 */
public interface Calculator {

    /**
     * Kiszámol egy indexet.
     *
     * @param userAttributeVO A felhasználó fizikai jellemzői.
     * @return A kiszámított {@code double} index.
     */
    double calulateIndex(UserAttributeVO userAttributeVO);

}
