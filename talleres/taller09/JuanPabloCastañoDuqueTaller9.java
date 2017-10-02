 

import java.util.Hashtable;
import java.util.Enumeration;

/**
 *
 * @author 
 */
public class Taller9{
  
    
 
    public static void agregar(Hashtable empresas,String key, String value){
        empresas.put(key, value);
    }
    
    //pedrito 2
    public static void buscar(Hashtable empresas,String key){
        
    }
    //pedrito 3
    public static boolean contienekey(Hashtable empresas,String key){
      return empresas.contains(key);
    } 
   public static void main(String[] args) {
    Hashtable empresas = new Hashtable();
    agregar(empresas, "Google", "EstadosUnidos");
    agregar(empresas, "La locura", "Colombia");
    agregar(empresas, "Nokia", "Finlandia");
    agregar(empresas, "Sony", "Japón");
   Enumeration<String> llaves = empresas.keys();
   while (llaves.hasMoreElements()) {
       System.out.println(""+ llaves.nextElement());
    }
    if(contienekey(empresas, "Google")){
        System.out.println(empresas.get("Google"));
    }
    else {
    }
    if(contienekey(empresas, "India")){
        
    }
    System.out.println ("No hay empresas de la india");
    
    
 
}
}
