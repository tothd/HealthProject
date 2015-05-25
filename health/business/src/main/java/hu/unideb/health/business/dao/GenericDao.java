package hu.unideb.health.business.dao;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Generikus, adatbázis műveletekhez.
 *
 * @param <T> gerikus típus a dao-hoz.
 */
public interface GenericDao<T extends Serializable> {

    /**
     * Adatbázisb táblájába beszúrás.
     *
     * @param instance Egy példány.
     * @return egy {@code int} ID.
     * @throws SQLException Adatbázisban fellépő hiba.
     */
    Long insert(T instance) throws SQLException;

    /**
     * Adatbázis táblájának valamely sorában érték frissítés.
     *
     * @param instance Egy példány.
     * @throws SQLException Adatbázisban fellépő hiba.
     */
    void update(T instance) throws SQLException;

    /**
     * Adatbázis táblájából törlés.
     *
     * @param instance Egy példány.
     * @throws SQLException Adatbázisban fellépő hiba.
     */
    void delete(T instance) throws SQLException;

}
