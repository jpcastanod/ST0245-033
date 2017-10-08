import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class lab1p1y1p2 {
private Node first;
private int size;
public lab1p1y1p2()
{
	size = 0;
	first = null;	
}

	/**
	 * Returns the node at the specified position in this list.
	 * @param index - index of the node to return
	 * @return the node at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	private Node getNode(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index < size) {
			Node temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
	 */
	public int get(int index) {
		Node temp = null;
		try {
			temp = getNode(index);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return temp.data;
	}

// Retorna el tamaño actual de la lista
public int size()
{
	return size;
}

// Inserta un dato en la posición index
public void insert(int data, int index)
{
    if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException ();   
    }
    if (index == 0) {
     Node nuevo = new Node (data);
     nuevo.next = first;
     first = nuevo;
     ++size;
    }
    else {
        Node nuevo = new Node (data);
        Node temp = first;
        for (int i = 1; i <= index-1; i++) {
            temp = temp.next;
    }
    nuevo.next = temp.next;
    temp.next = nuevo;
    size++;
}
}
// Borra el dato en la posición index
public void remove(int index)
{
        Node nuevo = new Node (index);
        Node temp = first;
 if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException ();   
    }
    
    else {
      for (int i = 1; i <= index-1; i++) {
           if (temp == nuevo) {  
               nuevo = null;
            }
            temp = temp.next;
           
    }
}
	
}

// Verifica si está un dato en la lista
public boolean contains(int data) {
    Node nuevo = new Node (data);
        Node temp = first;
 if (data < 0 || data > size) {
     throw new IndexOutOfBoundsException ();   
    }
    
    else {
      for (int i = 1; i <= data-1; i++) {
           if (temp == nuevo) {
                return true;
            }
            temp = temp.next;
           
    }
}
    
	return false;
}

}
