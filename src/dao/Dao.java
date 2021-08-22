package dao;

import java.util.List;
import java.util.Optional;

/**
 * Esta interficie va a servir tanto para la entidad Cuenta como para la entidad Titular
 * @param <T>
 */
public interface Dao<T> {

    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}