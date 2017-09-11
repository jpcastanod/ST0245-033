
import java.util.Arrays;

public class MiArrayListS {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int arreglo[]; 
  
  
    public MiArrayListS() {
        arreglo = new int[DEFAULT_CAPACITY];
    }     

    
    public int size() {
        return size;
    }      
    
    
    private void ensureCapa() {
        int newSize = arreglo.length * 2;
        arreglo = Arrays.copyOf(arreglo, newSize);
    }
    
    public void add(int e) {
        if (size == arreglo.length) {
            ensureCapa();
        }
        arreglo[size++] = e;
    }    
    
    
  
    public int get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return  arreglo[i];
    }
    
    
    public void add(int index, int e) {
        
        add ( arreglo[size-1]);
        for ( int i = arreglo.length; i>=0; i--) {
            arreglo[index+1] = arreglo [index] ;               
        }
            arreglo[index] = e;
            
        }
}
