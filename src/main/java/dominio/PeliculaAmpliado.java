
package dominio;


public class PeliculaAmpliado {
    private String nombre;
    private String Fproduccion;

    
    public PeliculaAmpliado(String nombre_peli, String fecha_produccion){
        this.nombre = nombre_peli;
        this.Fproduccion = fecha_produccion;
    }
    
    
   
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getFproduccion() {
        return Fproduccion;
    }

   
    public void setFproduccion(String Fproduccion) {
        this.Fproduccion = Fproduccion;
    }

    @Override
    public String toString() {
        return nombre + ";" + Fproduccion ;
    }
    
    
    
}
