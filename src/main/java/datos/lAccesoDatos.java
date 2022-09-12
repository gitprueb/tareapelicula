
package datos;

import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;


public interface lAccesoDatos {
    //si hay clavos manda a llamar a la clase de excepciones
boolean existe(String nombreArchivo)throws AccesoDatosEx;
public List<Pelicula> listar (String nombreArchivo)throws LecturaDatosEx;
void escribir(PeliculaAmpliado pelicula, String nombreArchivo,boolean anexar )throws EscrituraDatosEx;
public String Buscar(String nombreArchivo, String buscar)throws EscrituraDatosEx;
public String Busca(String nombreArchivo,String buscar)throws EscrituraDatosEx;
public void crear(String nombreArchivo)throws AccesoDatosEx;
public void borrar(String nombreArchivo)throws AccesoDatosEx;

  
    
    

}
