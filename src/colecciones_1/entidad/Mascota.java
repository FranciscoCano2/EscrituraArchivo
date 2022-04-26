package colecciones_1.entidad;

/**
 *
 * @author franc
 */
public class Mascota {

    private String raza;

//constructors
    public Mascota() {
    }

    public Mascota(String raza) {
        this.raza = raza;
    }

//getter
    public String getRaza() {
        return raza;
    }

//setter
    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Raza: " + raza;
    }
}
