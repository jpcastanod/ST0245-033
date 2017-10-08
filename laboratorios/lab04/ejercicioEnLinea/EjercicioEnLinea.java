
import java.util.*;
public class EnLinea
{
    public static void stack(int n,  Stack [] arreglo ){
        for (int i=0; i<n; ++i){
            Stack<Integer> stack = new Stack<Integer>();  
            stack.push(i);
            arreglo [i] = stack;
        }
    }
     public static void Moveaontob(int a, int b, Stack [] arreglo){ 
        for(int i=0; i < arreglo.length; i++){
            if(arreglo[i].contains(b)){
                if(arreglo[i].contains(a)){
                    break;
                }
                while(((int)arreglo[i].peek())!=(b)){
                    for(int j =0; j< arreglo.length;j++){
                        if(((int)arreglo[i].peek())==(j)){
                            arreglo[j].push(arreglo[i].pop());
                        }
                    }
                }          
                for(int k=0; k < arreglo.length; k++){
                    if(arreglo[k].contains(a)){
                        while(((int)arreglo[k].peek())!=(a)){
                            for(int l =0; i< arreglo.length;l++){
                                if(((int)arreglo[k].peek())==(l)){
                                    arreglo[l].push(arreglo[k].pop());
                                }
                            }   
                        }     
                        arreglo[i].push(arreglo[k].pop());   
                    }
                }
            }
        }   
    }
    
    public static void Moveaoverb(int a, int b, Stack [] arreglo){
        for (int i=0; i<arreglo.length; i++){
            if (arreglo[i].contains(b)){
                if(arreglo[i].contains(a)){
                    break;
                }
                for(int j= 0; j< arreglo.length; j++){
                    if(arreglo[j].contains(a)){
                        while(((int)arreglo[j].peek())!=(a)){
                            for(int k =0; k< arreglo.length;++k){
                                if(((int)arreglo[j].peek())==(k)){
                                    arreglo[k].push(arreglo[j].pop());
                
                                }
                            }
                        }     
                        arreglo[i].push(arreglo[j].pop());   
                    }              
                }
            }
        }   
    }
    
    public static void Pileaontob(int a, int b, Stack [] arreglo){
        for(int i=0; i < arreglo.length; i++){
            if(arreglo[i].contains(b)){
                if(arreglo[i].contains(a)){
                    break;
                }
                while(((int)arreglo[i].peek())!=(b)){
                    for(int j =0; j< arreglo.length;j++){
                        if(((int)arreglo[i].peek())==(j)){
                            arreglo[j].push(arreglo[i].pop());
                        }
                    }
                }         
                for(int k=0; k < arreglo.length; k++){
                    if(arreglo[k].contains(a)){
                        Stack <Integer> aux = new Stack <Integer>(); 
                        while(((int)arreglo[k].peek())!=(a)){
                            aux.push((int)arreglo[k].pop());
                        }
                        arreglo[i].push(arreglo[k].pop());  
                        for(int l=0; l <= aux.size(); l++){
                            arreglo[i].push(aux.pop());
                        } 
                    }
                }  
            }
        }   
    }
         public static void Pileaoverb(int a, int b, Stack [] arreglo){
        for (int i=0; i<arreglo.length; i++){
            if (arreglo[i].contains(a)){
                if(arreglo[i].contains(b)){
                    break;
                }
                for(int j= 0; j< arreglo.length; j++){
                    if(arreglo[j].contains(b)){
                        while(((int)arreglo[j].peek())!=(b)){
                            for(int k =0; k< arreglo.length;++k){
                                if(((int)arreglo[j].peek())==(k)){
                                    arreglo[k].push(arreglo[j].pop());
                
                                }
                            }
                        }     
                        arreglo[i].push(arreglo[j].pop());   
                    }              
                }
            }
        }   
    }
    
    public static void main(){
        Scanner sc = new Scanner(System.in);    
        int a;
        int b;
        int realizar;
        System.out.println("¿Cuántos bloques tendrá?");
        int x = sc.nextInt();
        Stack [] arreglo= new Stack [x];
        stack(x, arreglo);
        for (int i = 0; i<1 ;i--){
            System.out.println("1. Moveaontob");
            System.out.println("2. Moveaoverb");
            System.out.println("3. Pileaontob");
            System.out.println("4. Pileaoverb");
            System.out.println("5. Quit");          
            realizar = sc.nextInt();
            if(realizar == 1){
                    System.out.println("Digite el bloque a mover");
                    a = sc.nextInt();
                    System.out.println("Digite a donde se va a mover el bloque " + a);
                    b = sc.nextInt();
                    Moveaontob(a,b,arreglo);
                    break;
                }
              else if(realizar == 2){
                    System.out.println("Digite el bloque a mover");
                    a = sc.nextInt();
                    System.out.println("Digite a donde se va a mover el bloque  " + a);
                    b = sc.nextInt();
                    Moveaoverb(a,b,arreglo);
                    break;
                }
                   else if(realizar == 3){
                   System.out.println("Digite el bloque a mover");
                    a = sc.nextInt();
                    System.out.println("Digite a donde se va a mover el bloque  " + a);
                    b = sc.nextInt();
                    Pileaontob(a,b,arreglo);
                break;
            }
                  else if(realizar == 4){
                  System.out.println("Digite el bloque a mover");
                    a = sc.nextInt();
                    System.out.println("Digite a donde se va a mover el bloque  " + a);
                    b = sc.nextInt();
                    Pileaoverb(a,b,arreglo);
                    System.out.println("Si ha ocurrido un error, es porque la herramienta no está totalmente implementada ");
                    break;
                }
                   else if(realizar == 5){
                    for (int j=0; j<arreglo.length; j++){
                        System.out.println(j +": "+arreglo[j]);    
                    }  
                    break;              
                }
                else {
                    System.out.println("El rango va desde el 1 al 5");
                }
        }
    }
}
