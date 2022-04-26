package colecciones_1.util;

import colecciones_1.entidad.Mascota;
import colecciones_1.service.MascotaServiceImpl;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class MascotaOrchestrator {

    public void MascotaOrchestrator() throws IOException {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Archivo arch = new Archivo();
        MascotaServiceImpl p = new MascotaServiceImpl();
        String respuesta, razasacar;

        boolean auxcambiar = false;
        List<Mascota> razas = new ArrayList();

        do {
            Mascota pet = p.CrearMascota();
            razas = p.LlenarLista(pet, razas); //la lista ya esta creada

            do {
                System.out.println("¿Desea crear otra mascota? s/n ");
                respuesta = leer.next();
            } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));

        } while (!respuesta.equalsIgnoreCase("n"));

        razas = p.OrdenarLista(razas); //se ordena la lista

        arch.Archivo(razas); //se crea el archivo con las razas

        p.mostrarLista(razas); //imprimimos por pantalla el contenido de la lista
      
        do {
            System.out.println("Indique una raza a sacar");
            razasacar = leer.next();

            for (Mascota pet : razas) {
                if (pet.getRaza().equals(razasacar)) {
                    auxcambiar = true;
                }
            }

            if (auxcambiar == false) {
                System.out.println("La raza no esta en la lista");
            }

        } while (auxcambiar == false);

        razas = p.borrarElemento(razasacar, razas); //se vuelve a llenar la lista 

        arch.Archivo(razas); //se sobrescribe el archivo con la nueva lista

         p.mostrarLista(arch.leerArchivo()); //mostramos la lista final

    }

}
