
public class BinaryTree {
    public Node root;
 
        public BinaryTree(){
  root = null;
 }
  
    private int max2(int i, int j)
    {
        if (i > j)
            return i;
        return j;
    }
    
    private int maxheightAUX(Node node)
    {
        if (node == null)
                return 0;
        else 
                return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
    }
    
    public int maxheight()
    {
       return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }
        
        
    }
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }
    
    private boolean search(Node nodo, int x)
    {
         System.out.println ("Buscado");
        if(nodo == null)
            return false;
        if(nodo.data == x)
            return true;
        if(nodo.data < x)
       
        return search(nodo.right,x);        
        return search(nodo.left,x); 
    }
    
     public void insert(int x){
          System.out.println ("Insertado");
        insertAux(root, x);
    }
    
    private void insertAux(Node nodo, int x)
    {
        if(nodo == null)
            root = new Node(x);
        else if(x >= nodo.data)
        {
            if(nodo.right == null)
                nodo.right = new Node(x);
            else
                insertAux(nodo.right,x);
        }
        else {
            if(nodo.left == null)
                nodo.left = new Node(x);
            else
                insertAux(nodo.left,x);
        }
    }
    
    private void addNodo(Node nodo, Node root)
    {
       if(root == null)
            root = nodo;
        else if(nodo.data >= root.data)
        {
            if(nodo.right == null)
                root.right = nodo;
            else
                addNodo(nodo,root.right);
        }
        else {
            if(root.left == null)
                root.left = nodo;
            else
                addNodo(nodo,root.left);
        }  
    }

    public void delete(int n)
    {
         System.out.println ("Eliminado");
        delete(root,n);
    }
    
    private void delete(Node nodo,int x)
    {
        if(nodo == null)
            return;
        if(nodo.data == x)
        {
           Node nodoTemp = (nodo.left);
            root = (nodo.right);
            if(nodoTemp!=null)
                addNodo(nodoTemp,root);
            return;
        }
        if(nodo.right != null)
        {
            if((nodo.right).data == x)
            {
                Node nodoTemp = ((nodo.right).left);
                (nodo.right) = (nodo.right).right;
                if(nodoTemp!=null)
                    addNodo(nodoTemp,root);
                return;
           }
           else if(x >= nodo.data)
            delete(nodo.right,x);  
        }
        if(nodo.left != null)
        {
            if((nodo.left).data == x)
            {
                Node nodoTemp = (nodo.left).right;
                (nodo.left) = (nodo.left).left;
                if(nodoTemp!=null)
                    addNodo(nodoTemp,root);
                return;
            }
            else if(x < nodo.data)
                delete(nodo.left,x); 
        }    
    }
}
        

    
 
