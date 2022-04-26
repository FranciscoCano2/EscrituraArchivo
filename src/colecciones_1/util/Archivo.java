package colecciones_1.util;

import colecciones_1.entidad.Mascota;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Archivo {

    public final String ruta = "C:\\Users\\franc\\Desktop/Mascotas Razas.txt";

    public void Archivo(List<Mascota> m) throws IOException {

        File file = new File(ruta);
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta)); //BufferedWriter bw = new BufferedWriter(fw); //no se que problema es

        try {
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            for (Mascota pet : m) {
                String contenido = pet.getRaza();

                bw.write(contenido);
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
        }

    }

    public List<Mascota> leerArchivo() {

        ArrayList<Mascota> lista = new ArrayList();
        BufferedReader objReader = null;

        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(ruta));

            while ((strCurrentLine = objReader.readLine()) != null) {

                Mascota raza = new Mascota();
                raza.setRaza(strCurrentLine);
                lista.add(raza);

            }

        } catch (IOException e) {

        } finally {

            try {
                if (objReader != null) {
                    objReader.close();
                }

            } catch (IOException ex) {
            }
        }

        return lista;
    }
}
