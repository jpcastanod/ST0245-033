import java.io.*;
import java.util.*;

public class EjercicioEnLinea {
    LinkedList<String> Teclado = new LinkedList<String>();

    public LinkedList<String> teclear(String entrada) {
        int a = 0;
        for (int i = 0; i < entrada.length(); ++i) {
            if (entrada.charAt(i) == '[') {
                a = 0;
            } else if (entrada.charAt(i) == ']') {
                a = Teclado.size();
            } else {
                Teclado.add(a, entrada.charAt(i)+"");
                a++;
            }
        }
        return Teclado;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String entrada = br.readLine();
        EjercicioEnLinea ej = new EjercicioEnLinea();
        String out = ej.teclear(entrada).toString();
       ej.MostrarTexto(out);   
    }

   
    public  void MostrarTexto(String str ){
        String Texto = "";
        for(int i = 0; i < str.length();++i){
            if(!(str.charAt(i) == ',' )){
            Texto = Texto + str.charAt(i);
            }
        }
        System.out.println (Texto);
    }
}
