package colecciones_1.service;

import colecciones_1.entidad.Mascota;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class MascotaServiceImpl implements MascotaService {

    private final Scanner leer;

    public MascotaServiceImpl() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }

    @Override
    public Mascota CrearMascota() {
        Mascota pet = new Mascota();

        System.out.println("Escriba la raza de su Mascota");
        pet.setRaza(leer.next());

        return pet;
    }

    @Override
    public List CrearLista(Mascota m) {

        ArrayList<Mascota> razas = new ArrayList();
        razas.add(m);

        return razas;
    }

    @Override
    public List LlenarLista(Mascota m, List r) {

        r.add(m);

        return r;
    }

    public void mostrarLista(List<Mascota> lista) {

        for (Mascota pet : lista) {
            System.out.println(pet);
        }

    }

    public List borrarElemento(String sacar, List r) {

        Iterator<Mascota> it = r.iterator();

        while (it.hasNext()) {
            //Hacemos una variable auxiliar y la obligamos a que sea String (cast)
            Mascota borrar = (Mascota) it.next();
            if (borrar.getRaza().equals(sacar)) {
                System.out.println("Vamos a remover " + borrar);
                it.remove();
            }
        }
        return r;
    }
 
    @Override
    public List OrdenarLista(List r) {

        Collections.sort(r, (Mascota obj1, Mascota obj2) -> obj1.getRaza().compareTo(obj2.getRaza()));
        return r;
    }

}