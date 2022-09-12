
package datos;

import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



    public abstract class AccesoDatoslmpl implements lAccesoDatos {

  

    

   

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
       File archivo = new File(nombreArchivo);
       return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
       List<Pelicula> peliculas = new ArrayList();
       File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura;
            lectura = entrada.readLine();
            
            int NoLinea=1;
            while (lectura != null){
                
                System.out.println("Linea:"+NoLinea+"  Lectura:"+lectura);
                lectura = entrada.readLine();
                NoLinea++; 
            }
            
            entrada.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (IOException ex){
            System.out.println("Hay otro tipo de problema");
        }
        return null;
    }

    @Override
    public void escribir(PeliculaAmpliado pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
       PrintWriter salida= null;
     
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("se ha escrito el registro de pelicula");
        } 
        catch (Exception e) {
        }
    }

    @Override
    public String Buscar(String nombreArchivo, String buscar) throws EscrituraDatosEx {
       BufferedReader entrada = null;
       String resultado= null;
        try {
                File archivo = new File(nombreArchivo);
            
            entrada = new BufferedReader(new FileReader(archivo));
            String linea= null;
            int i=1;
            linea= entrada.readLine();
            
            while(linea != null){
                if(buscar  != null && buscar.equalsIgnoreCase(linea)){
                    resultado= "Peli:" +linea+ "ecnontrada en la linea=" +i;
                    break;
                }
            linea= entrada.readLine();
            i++;        
        }       
        entrada.close();
        
        } catch (FileNotFoundException ex) {
            System.out.println("no se encontro"+ex.getMessage());
        }catch(IOException ex){
            System.out.println("problema de archivo"+ex.getMessage());
        }finally{
            try {
                entrada.close();
            } catch (Exception e) {
            }
        }

        
        
        
        return resultado;

}
    
    @Override
    public String Busca(String nombreArchivo, String busca) throws EscrituraDatosEx {
       BufferedReader entrada = null;
       String resultado= null;
        try {
            File archivo = new File(nombreArchivo);
            
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=1;
            linea= entrada.readLine();
            
            while(linea != null){
                if( busca.equalsIgnoreCase(linea)){
                    resultado = " Peli:" +linea+ "ecnontrada en la linea=" +i;
                    break;
                }
            linea= entrada.readLine();
            i++;        
        }       
        entrada.close();
        
        } catch (FileNotFoundException ex) {
            System.out.println("no se encontro"+ex.getMessage());
        }catch(IOException ex){
            System.out.println("problema de archivo"+ex.getMessage());
        }finally{
            try {
                entrada.close();
            } catch (Exception e) {
            }
        }

        
        
        
        return resultado;

}

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        PrintWriter salida= null;
        try {
           File archivo = new File(nombreArchivo);
            salida= new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            System.out.println("Problema al crear archivo"+ex.getMessage());
        }
    }
    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo= new File(nombreArchivo);
        archivo.delete();
        System.out.println("El archivo se elimino");
    }


    
}
    

