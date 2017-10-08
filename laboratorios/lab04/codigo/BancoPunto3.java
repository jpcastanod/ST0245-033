import java.util.Scanner;

public class lab1
{
    public static Scanner sc = new Scanner(System.in);
    public static Scanner sct = new Scanner(System.in);
    private static String [] [] filas;
    private static String cajero1= "Cajero1";
    private  static String cajero2= "Cajero2";
    public static void pedirFila1 () {
        System.out.println ("Cuantos usuarios va a tener la fila1");
        int n = sc.nextInt();
        String nombre = "";
        for (int i =0; i<n; i++) {
         System.out.println ("Escriba el nombre de la persona " + i+1);
         nombre = sct.nextLine();
         filas [0][i] = nombre;
        }
    }
      public static  void pedirFila2 () {
        System.out.println ("Cuantos usuarios va a tener la fila 2");
        int n = sc.nextInt();
        String nombre = "";
        for (int i =0; i<n; i++) {
         System.out.println ("Escriba el nombre de la persona " + i+1);
         nombre = sct.nextLine();
         filas [1] [i] = nombre;
        }
    }
      public static  void pedirFila3 () {
        System.out.println ("Cuantos usuarios va a tener la fila 3");
        int n = sc.nextInt();
        String nombre = "";
        for (int i =0; i<n; i++) {
         System.out.println ("Escriba el nombre de la persona " + i+1);
         nombre = sct.nextLine();
         filas [2][i] = nombre;
        }
    }
      public static void pedirFila4 () {
        System.out.println ("Cuantos usuarios va a tener la fila 4");
        int n = sct.nextInt();
        String nombre = "";
        for (int i =0; i<n; i++) {
         System.out.println ("Escriba el nombre de la persona " + i+1);
         nombre = sc.nextLine();
         filas [3][i] = nombre;
        }
    }
    public static void main (){
        pedirFila1();
        pedirFila2();
        pedirFila3();
        pedirFila4();
        int x = 0;
        if (filas[0].length > filas[1].length && filas[0].length>filas[2].length && filas[0].length> filas[3].length) {
            x = filas[0].length;
        }
        else if (filas[1].length > filas[0].length && filas[1].length>filas[2].length && filas[1].length> filas[3].length) {
            x = filas[1].length;
        }
        else if (filas[2].length > filas[0].length && filas[2].length>filas[1].length && filas[2].length> filas[3].length) {
            x = filas[2].length;
        }
        else {
            x= filas[3].length;
        }
        
        for(int i = 0; i<x; i++){
            int j=0;
            for(; j<=3; j= j+2){
                System.out.println(cajero1 +"atendió a: " + filas[j][i]);
                System.out.println(cajero2 +"atendió a: "+ filas[j+1][i]);
            }
        }
    
    }
}
