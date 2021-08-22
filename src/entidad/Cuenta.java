package entidad;

import java.util.concurrent.atomic.AtomicInteger;

public class Cuenta {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private int id;
    private String iban;
    private double efectivo;

    public Cuenta(String iban, double efectivo) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.iban = iban;
        this.efectivo = efectivo;
    }

    public int getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }
}
