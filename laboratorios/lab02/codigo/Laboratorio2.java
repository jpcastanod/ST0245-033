
import java.util.Random;
public class Lab02 {
   
    public int arraySum(int[] array) {
        int suma = 0;
        try        
        {
            Thread.sleep(100);     
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
        
        for (int i = 0; i < array.length; i++)
        suma = suma + array[i];
        return suma;
    }
    public static int ArrayMax(int[] array)
    {
        int max = array[0];
        try        
        {
            Thread.sleep(100);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }       
        for (int i = 0; i < array.length; i++)
        if (max < array[i])
        max = array[i];
        return max;
    }
    public static void InsertionSort(int[] array)
    {
        int aux;
        int x;
        try        
        {
            Thread.sleep(100);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
        
        
        for (int i = 0; i < array.length; i++)
        {
            x = i;
            while (x > 0 && array[x-1] > array[x])
            {
                aux = array[x];
                array[x] = array[x-1];
                array[x-1] = aux;
                x = x-1;
            }           
        }
    }

    public static void mergeSort(int [ ] array)
    {
         int[] aux = new int[array.length];
        try        
        {
            Thread.sleep(100);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
        mergeSort(array, aux,  0,  array.length - 1);
    }

    private static void mergeSort(int [ ] array, int [ ] aux, int left, int right)
    {
        if( left < right )
    {
        int medio = (left + right) / 2;
        mergeSort(array, aux, left, medio);
        mergeSort(array, aux, medio + 1, right);
        merge(array, aux, left, medio + 1, right);
    }
    }
    
    private static void merge(int[ ] array, int[ ] aux, int left, int right, int dEnd )
    {
        int iEnd = right - 1;
        int i = left;
        int num = dEnd - left + 1;

        while(left <= iEnd && right <= dEnd)
            if(array[left] <= array[right] )
                aux[i++] = array[left++];
            else
                aux[i++] = array[right++];
        while(left <= iEnd)    
            aux[i++] = array[left++];

        while(right <= dEnd)  
            aux[i++] = array[right++];

        for(int j = 0; j < num; j++, iEnd--)
            array[dEnd] = aux[dEnd];
    }
    

    public static void main(){
        Lab02 max = new Lab02();       
        
          for(int i = 10000; i <= 10000000; i = i * 10){
            int pos = i;
            int[] azar = new int[pos];
            for(int j = pos - 1; j >= 0; j--){  
                azar[j] = (int)(Math.random() * 100 + 1);
            }
            
            long Tiempoinicial = System.currentTimeMillis();
            max.mergeSort(azar); 
            long Tiempoestimado = System.currentTimeMillis() - Tiempoinicial;
            System.out.println("Merge Sort "+i+" : "+Tiempoestimado);
        }
          for(int i = 10000; i <= 10000000; i = i * 10){
            int pos = i;
            int[] azar = new int[pos];
            for(int j = pos - 1; j >= 0; j--){  
                azar[j] = (int)(Math.random() * 100 + 1);
            }            
            long Tiempoinicial = System.currentTimeMillis();
            max.InsertionSort(azar); 
            long Tiempoestimado = System.currentTimeMillis() - Tiempoinicial;
            System.out.println("Insertion Sort "+i+" : "+Tiempoestimado);
        }
          for(int i = 10000; i <= 10000000; i = i * 10){
            int pos = i;
            int[] azar = new int[pos];
            for(int j = pos - 1; j >= 0; j--){  
                azar[j] = (int)(Math.random() * 100 + 1);
            }
            
            long Tiempoinicial = System.currentTimeMillis();
            max.arraySum(azar); 
            long Tiempoestimado = System.currentTimeMillis() - Tiempoinicial;
            System.out.println("Array Sum "+i+" : "+Tiempoestimado);
        }
        for(int i = 10000; i <= 10000000; i = i * 10){
            int pos = i;
            int[] azar = new int[pos];
            for(int j = pos - 1; j >= 0; j--){  
                azar[j] = (int)(Math.random() * 100 + 1);
            }
            
            long Tiempoinicial = System.currentTimeMillis();
            max.ArrayMax(azar); 
            long Tiempoestimado = System.currentTimeMillis() - Tiempoinicial;
            System.out.println("Array Max "+i+" : "+Tiempoestimado);
        } 
    }
}
