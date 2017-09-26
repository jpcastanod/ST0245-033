import java.util.*;

/**
 *
 * @author 
 */
public class Taller8 {
    
    //Punto 1
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack <Integer> aux = new Stack <Integer> ();
        while (stack.size()>0){
            aux.push(stack.pop()) ;           
        }       
       return aux;
    }
    
    
    //Punto 2
    public static void cola (Queue<String> queue){
        while (queue.size () > 0) {
        System.out.println ("Atendiendo a: " + queue.poll());
    }
    }
    
    
    //notacion polaca
    public static int polaca  (String string){
     Stack <Integer> aux = new Stack <Integer> ();
     Stack <String> aux2 = new Stack <String> ();
    int answer = 0;
    int x = 0;
    String s = "";
     for (int i = 0; i< string.length (); i++) {
         if (string.substring (i, i+1)  == "+"|| string.substring (i, i+1)  == "-" || string.substring (i, i+1)  == "*"|| string.substring (i, i+1)  == "/" ){
            aux2.push (string.substring (i, i+1));
            }
            else if ( string.substring (i, i+1)  == " ")
            {
                i--;
            }
            else {
            int j = 0;
     aux.push (Integer.parseInt(string.substring (j, j+1)));
     j++;
    
    
         if (i%2 == 0) {
             answer += aux.pop ();
        }
    }
    }
    return answer;
}
}
// Aclaro que el último ejercicio no me funcionó correctamente, pero como se va a terminar el tiempo, decidi enviarlo así //
