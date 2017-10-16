import java.util.*;
public class Lab03
{
   public static int mulLista (List<Integer> list){
       int mult = 1;
       for (int i =0; i<list.size();i++){
           mult = mult* list.get(i);
        }
        return mult;   
    }
    public static int smartInsert (List<Integer> list, int data) {
        
        if (list.contains(data)){
            System.out.println ("El número ya está en la lista");
            imprimirLista(list);
            return 0;        
        }
        System.out.println ("Se añadió el elemento a la lista");
        list.add(data);
         imprimirLista(list);
            return 0;
    }
    
    public static void imprimirLista (List<Integer> list){
        for (int i =0; i<list.size();i++){
            System.out.println (list.get(i));
        }
    }
     public static int pivote (List<Integer> list)                                                                  
    {
        int pivote = list.get(1);                                                                                  
        int balance = Math.abs(Sumar(list.subList(0, 1)) - Sumar(list.subList(2, list.size())));             
        for (int i = 2; i < list.size() - 1; i++)                                                                  
        {
            if (Math.abs(Sumar(list.subList(0, i)) - Sumar(list.subList(i + 1, list.size()))) <= balance)    
            {
                balance = Math.abs(Sumar(list.subList(0, i)) - Sumar(list.subList(i + 1, list.size())));     
                pivote = list.get(i);                                                                              
            }
        }
        return pivote;                                                                                             
    }
 
    public static int Sumar (List<Integer> lista)     
    {
        int suma = 0;                                   
        for (int i = 0; i < lista.size(); i++)       
        {
            suma = suma + lista.get(i);                
        }
        return suma;                                  
    }
     public static void ejercicio4(LinkedList<String> neveras, LinkedList<String> solicitudes)
    {
        LinkedList<String> List = new LinkedList<String>();
        int aux = neveras.size();
        int cantidad = 0;
        String s1, s2;
        for (int i = solicitudes.size() - 1; i >= 0; i--)
        {
            s1  = solicitudes.get(i).substring(solicitudes.get(i).length() - 2, solicitudes.get(i).length() - 1);
            s2 = solicitudes.get(i).substring(solicitudes.get(i).length() - 3, solicitudes.get(i).length() - 2);
            if (s1.matches(".*\\d.*") && !s2.matches(".*\\d.*"))
            {
                cantidad = Integer.parseInt(s1);
                if (cantidad < aux)
                    List.add(solicitudes.get(i).substring(0, solicitudes.get(i).length() - 4) + ", " + neveras.subList(aux - cantidad, aux) + ")");
                    else
                    List.add(solicitudes.get(i).substring(0, solicitudes.get(i).length() - 4) + ", " + neveras.subList(0, aux) + ")");
            }

        }
        System.out.println(List);
    }
    public static void Nevera(LinkedList<String> list, int codigo)
    {
        String nevera = "(" + codigo + ", " + ")";
        list.add(nevera);
    }
    public static void Solicitud(LinkedList<String> list, int cantidad, String cliente)
    {
        String solicitud = "(" + cliente + ", " + cantidad + ")";
        list.add(0, solicitud);
    }
    public static void main () {
      for (int z= 0; z<1;z--){  
        System.out.println ("Qué método desea ejecutar: 1.MulLista, 2. SmartInsert u otro número para salir del programa");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list= new ArrayList <Integer> ();
            for (int i =0; i<1; i--){
                System.out.println ("Ingrese el número: " + (i+1) + " de la lista, si no desea agregar mas, ingrese -1000");
                int x = sc.nextInt();
                if (x== -1000){
                    break;
                }
                list.add(x);
            }
            if (n==1){
                    System.out.println ("El metodo mul arreglo devuelve: " + mulLista (list));
                }
            else if (n==2){
                        System.out.println("ingrese el dato que desea ingresar a la lista ");
                        int data = sc.nextInt();
                        smartInsert (list, data);
                }
            else if (n==3){
              System.out.println ("El metodo mul arreglo devuelve: " + pivote (list));
                }
            else{
                break;
                }
        }
    }
}
