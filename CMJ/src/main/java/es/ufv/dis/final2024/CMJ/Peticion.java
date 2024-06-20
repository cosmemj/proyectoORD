package es.ufv.dis.final2024.CMJ;

public class Peticion {
    public String ship;

    public Peticion(String ship) {
        this.ship = ship;
    }

    public Peticion() {}

    public String getship() {
        return ship;
    }

    public void setship(String ship) {
        this.ship = ship;
    }

    @Override
    public String toString() {
        return "Peticion{" +
                "ship='" + ship + '\'' +
                '}';
    }
}
