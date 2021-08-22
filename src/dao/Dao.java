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

    void registrar(T t);

    void modificar(T t);

    void eliminar(T t);
}