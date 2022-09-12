
package datos;

import dominio.PeliculaAmpliado;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class AccesoDatosAdiclmpl extends AccesoDatoslmpl {
    private List<PeliculaAmpliado> peliFecha= new  ArrayList<PeliculaAmpliado>();
    
    public void cargarInformacion(String nombreArchivo) throws LecturaDatosEx{
        peliFecha= new ArrayList<PeliculaAmpliado>();
        try {
            BufferedReader entrada = null;
            File archivo= new File(nombreArchivo);
            
            entrada= new BufferedReader(new FileReader(archivo));
            String linea= null;
            linea= entrada.readLine();
            while(linea == null){
                String nombrePe;
                String year = null;
                String [] arreglo= linea.split(";");
                nombrePe= arreglo[0];
                year = arreglo[1];
                // sugerir como validar que no de error esto
                PeliculaAmpliado pelicula= new PeliculaAmpliado(nombrePe, year);
                peliFecha.add(pelicula);
                linea= entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }

   
}