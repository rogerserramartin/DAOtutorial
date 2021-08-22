package dao;

import conexion.ConexionBBDD;
import entidad.Titular;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Como Dao<T> es una interfície genérica, le paso un <Titular>
 */
public class TitularDao implements Dao<Titular>{

    ConexionBBDD conexionBBDD;

    public TitularDao(ConexionBBDD conexionBBDD) {
        this.conexionBBDD = conexionBBDD;
    }

    @Override
    public Optional<Titular> get(long id) {
        Titular titular = new Titular();
        try {
            this.conexionBBDD.conectar();
            PreparedStatement preparedStatement = this.conexionBBDD.getConexion().prepareStatement("SELECT * FROM Titular WHERE id = " + id);
            ResultSet resultSet = preparedStatement.executeQuery();

            titular.setNombre(resultSet.getString("nombre"));
            titular.setEdad(resultSet.getInt("edad"));
            titular.setDireccion(resultSet.getString("direccion"));
            titular.setEmail(resultSet.getString("email"));

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.conexionBBDD.desconectar();
        } return Optional.of(titular);
    }

    @Override
    public List<Titular> getAll() {
        List<Titular> lista = new ArrayList<>();
        try {
            this.conexionBBDD.conectar();
            PreparedStatement preparedStatement = this.conexionBBDD.getConexion().prepareStatement("SELECT * FROM Titular");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Titular titular = new Titular();
                titular.setNombre(resultSet.getString("nombre"));
                titular.setEdad(resultSet.getInt("edad"));
                titular.setDireccion(resultSet.getString("direccion"));
                titular.setEmail(resultSet.getString("email"));
                lista.add(titular);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.conexionBBDD.desconectar();
        }
        return lista;
    }

    @Override
    public void registrar(Titular titular) {
        try {
            this.conexionBBDD.conectar();
            PreparedStatement preparedStatement = this.conexionBBDD.getConexion()
                    .prepareStatement("INSERT INTO Titular(nombre, edad, direccion, email) VALUES(?,?,?,?)");
            // se empieza por indice 1, ya que el ID es autogenerado, sino sería índice0 y getId()
            preparedStatement.setString(1, titular.getNombre());
            preparedStatement.setInt(2, titular.getEdad());
            preparedStatement.setString(3, titular.getDireccion());
            preparedStatement.setString(4, titular.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.conexionBBDD.desconectar();
        }

    }

    @Override
    public void modificar(Titular titular) {
        try {
            this.conexionBBDD.conectar();
            PreparedStatement preparedStatement = this.conexionBBDD.getConexion()
                    .prepareStatement("UPDATE Titular SET nombre = ?, edad = ?, direccion = ?, email = ? WHERE id = " +
                            titular.getId());
            preparedStatement.setString(1, titular.getNombre());
            preparedStatement.setInt(2, titular.getEdad());
            preparedStatement.setString(3, titular.getDireccion());
            preparedStatement.setString(4, titular.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.conexionBBDD.desconectar();
        }

    }

    @Override
    public void eliminar(Titular titular) {
        try {
            this.conexionBBDD.conectar();
            PreparedStatement preparedStatement = this.conexionBBDD.getConexion()
                    .prepareStatement("DELETE FROM Titular WHERE id = " + titular.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.conexionBBDD.desconectar();
        }

    }
}
