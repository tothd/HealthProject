package hu.unideb.health.shared.service;

import hu.unideb.health.shared.exception.ExistingUserException;
import hu.unideb.health.shared.exception.UserNotFoundException;
import hu.unideb.health.shared.vo.UserAttributeVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import hu.unideb.health.shared.vo.UserVO;

/**
 * A felhasználó adataihoz kapcsolódó adatbázis műveleteket megvalósító
 * szolgáltatás.
 */
public interface UserDataService {

    /**
     * Létrehoz egy új felhasználót az adatbázisban.
     *
     * @param user A felhasználó nevét, azonosítóját és jelszavát tartalmazó
     * osztály.
     * @param userAttribute A felhasználó fizikai jellemzőit tartalmazó osztály.
     * @return A felhasználó nevét, azonosítóját és jelszavát tartalmazó
     * osztály, amit elhelyeztünk az adatbázisban.
     * @throws ExistingUserException létező felhasználó esetén keletkező hiba.
     */
    UserVO createUser(UserVO user, UserAttributeVO userAttribute) throws ExistingUserException;

    /**
     * Megtalál egy felhasználót az adatbázisban név és jelszó alapján.
     *
     * @param name Felhasználó neve.
     * @param password Felhasználó jelszava,
     * @return Megtalált felhasználó névvel, azonosítóval, jelszóval.
     * @throws UserNotFoundException Nem létező felhasználó esetén keletkező hiba.
     */
    UserVO findByNameAndPassword(String name, String password) throws UserNotFoundException;

    /**
     * Megtalálja a módosítani kívánt felhasználó adatait azonosító alapján.
     *
     * @param id Felhasználó {@code long}  azonosítója.
     * @return A felhasználó fizikai jellemzőit tartalmazó osztály.
     */
    UserAttributeVO findUserDataModificationById(Long id);

    /**
     * Módosítja az adatbázisban a felhasználó fizikai jellemzőit.
     *
     * @param userAttributeVO A felhasználó fizikai jellemzőit tartalmazó
     * osztály.
     */
    void modifyUserAttribute(UserAttributeVO userAttributeVO);
    
    /**
     * Megtalálja a felhasználó kiszámított indexeit.
     * 
     * @param id Felhasználó {@code long}  azonosítója.
     * @return Indexeket tartalmazó osztály.
     */
    UserIndexesVO findUserIndexesById(long id);

}
