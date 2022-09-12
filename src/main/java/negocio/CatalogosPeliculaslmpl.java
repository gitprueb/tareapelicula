
package negocio;

import datos.AccesoDatoslmpl;
import datos.lAccesoDatos;
import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;;
import java.util.List;


public class CatalogosPeliculaslmpl implements CatalogoPeliculas{
    private final lAccesoDatos datos;
    
    public CatalogosPeliculaslmpl(){
        this.datos = new AccesoDatoslmpl() {};
    }
    @Override
    public void agregarPeliculas(String nombrePelicula, String yeah, String nombreArchivo) {
        PeliculaAmpliado pelicula = new PeliculaAmpliado(nombrePelicula, yeah);
        
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);// si existe anexa informacion, si no va a crear el archivo
            datos.escribir(pelicula, nombreArchivo,anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al acceder a los datos");
        }
    }


    @Override
    public void ListarPeliculas(String nombreArchivo) {
        try {
            List<Pelicula> peliculas = datos.listar(nombreArchivo);
            System.out.println("=========listar peliculas========");
            for( Pelicula peli : peliculas){
                System.out.println ("Peli:" + peli);
            }
         
        } catch (Exception e) {
            System.out.println("clavos con el acceso a datos");
        }
    }

    @Override
    public void buscarPeliculas(String nombreArchivo, String buscar) {
        String resultado= "";
        try {
            resultado= datos.Buscar(nombreArchivo,buscar);
        } catch (EscrituraDatosEx ex) {
            System.out.println("error al buscar la peli");
        }
        System.out.println(" resultado = " + resultado);
    }
    
    @Override
    public void buscaran(String nombreArchivo, String busca) {
        String resultado= "";
        try {
            resultado= datos.Busca(nombreArchivo,busca);
        } catch (EscrituraDatosEx ex) {
            System.out.println("error al buscar el año");
        }
         System.out.println("resultado=" + resultado);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if(datos.existe(nombreArchivo)){
               //si existe lo borra
                datos.borrar(nombreArchivo);
            }else{
               //creamos el archivo
               datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("error de acceso a datos");
        }
    }
    
}
