package colecciones_1.service;

import colecciones_1.entidad.Mascota;
import java.util.List;

/**
 *
 * @author franc
 */
public interface MascotaService {

    public Mascota CrearMascota();

    public List CrearLista(Mascota m);

    public List LlenarLista(Mascota m, List r);

    public List OrdenarLista(List r);

}
