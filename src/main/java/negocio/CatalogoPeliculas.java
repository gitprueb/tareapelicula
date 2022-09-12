
package negocio;


public interface CatalogoPeliculas {
    public void agregarPeliculas(String nombrePelicula, String yeah, String nombreArchivo);
    public void ListarPeliculas(String nombreArchivo);
    public void buscarPeliculas(String nombreArchivo,String buscar);
    public void buscaran(String nombreArchivo,String buscar);
    public void iniciarArchivo(String nombreArchivo);
    
}
    

