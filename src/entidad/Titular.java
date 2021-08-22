package entidad;

import java.util.concurrent.atomic.AtomicInteger;


public class Titular {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private final int id;
    private String nombre;
    private int edad;
    private String direccion;
    private String email;

    public Titular(String nombre, int edad, String direccion, String email) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
