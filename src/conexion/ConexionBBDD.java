package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que crea una objeto de tipo ConexionBBDD para simplificar el acceso a base de datos SQL
 */

public class ConexionBBDD {

    private Connection conexion;
    private String jdbcDriver;
    private String urlBaseDatos;
    private String usuario;
    private String password;

    /**
     * Sólo creamos una conexión con 4 de los 5 parámetros, ya que conexión se instanciará con el método conectar()
     * @param jdbcDriver es el driver de cada BBDD SQL (Oracle, MySQL, Postgres...)
     * @param urlBaseDatos dirección del servidor donde se encuentra la BBDD
     * @param usuario usuario creado en la BBDD
     * @param password contraseña asignada para el usuario
     */
    public ConexionBBDD(String jdbcDriver, String urlBaseDatos, String usuario, String password) {
        this.jdbcDriver = jdbcDriver;
        this.urlBaseDatos = urlBaseDatos;
        this.usuario = usuario;
        this.password = password;
    }

    /**
     * Método que crea una nueva conexión con la BBDD
     */
    public void conectar(){
        try {
            this.conexion = DriverManager.getConnection(this.urlBaseDatos, this.usuario, this.password);
            Class.forName(this.jdbcDriver);

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Método que cierra la conexión instanciada en el método conectar()
     */
    public void desconectar(){
        // Sólo se va a poder desconectar si hay una conexión activa
        if(this.conexion != null) {

            try {
                // Si la conexión está abierta, la cerramos
                if(!this.conexion.isClosed()){
                    this.conexion.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    /**
     * Hacer el set de jdbc
     * @param jdbcDriver es un controlador que permite que la aplicación Java interactúe con la BBDD
     */
    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    /**
     * Hacer el set de la URL
     * @param urlBaseDatos ubicación de la BBDD
     */
    public void setUrlBaseDatos(String urlBaseDatos) {
        this.urlBaseDatos = urlBaseDatos;
    }

    /**
     * Hacer el set del usuario
     * @param usuario usuario creado en la BBDD
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Hacer el set de la contraseña
     * @param password es la contraseña asignada al usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
