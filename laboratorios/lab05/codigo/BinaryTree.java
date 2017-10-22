public class BinaryTree {
    public Node root;
 
    public BinaryTree(){
        root = null;
    }
    
    private int max2(int i, int j){
        if (i > j){
            return i;
        }
        return j;
    }
     public void recursivePrint(){
        recursivePrintAUX(root);
    }
    
    private int maxheightAUX(Node node){
        if (node == null){
            return 0;
        }
        else {
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
        }
    }
    
    public int maxheight(){
       return maxheightAUX(root);
    }
    
    public void insertar(String nombre, String sexo){
        if(root == null){
            root = new Node(nombre);;
        }
        insertar(root, nombre, sexo);
    }
    
    private Node buscar(Node nodo, String nombre){
        if(nodo == null){
            return null;
        }
        else{
            if(nodo.data.equals(nombre)){
                return nodo;
            }
            Node izq = buscar(nodo.left, nombre);
            if(izq != null){
                return izq;
            }
            Node der = buscar(nodo.right, nombre);
            if(der != null){
                return der;
            }
            return null;
        }
    }
    private boolean insertar(Node nodo, String nombre, String sexo){
        if(nodo.data == nombre){
            return false;
        }
        if(sexo.equalsIgnoreCase("mujer")){
            if(nodo.left == null){
                nodo.left = new Node(nombre);
                return true;
            }
            else{
                return insertar(nodo.left, nombre, sexo);
            }
        }
        if(sexo.equalsIgnoreCase("hombre")){
            if(nodo.right == null){
                nodo.right = new Node(nombre);
                return true;
            }
            else{
                return insertar(nodo.right, nombre, sexo);
            }
        }
        return false;
    }
    
    public boolean buscar(String nombre){
        if(buscar(root, nombre) == null){
            return false;
        }
        return true;
    } 
    public String getNomAbuela(String nombre){
        if(root == null){
            root = new Node(nombre);
        }
        return getNomAbuela(root, nombre);
    }

    private void recursivePrintAUX(Node node){
        if (node != null){
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }
    }
    public String getNomAbuela(Node nodo, String nombre){
        Node nieto = buscar(nodo, nombre);
        if(nieto == null){
            return "";
        }
        else{
            if(nieto.left == null){
                return "";
            }
            else{
                if(nieto.left.left == null){
                    return "";
                }
                else{
                    return nieto.left.left.data;
                }
            }
        }
    }
   
    
    public static void main(){
        BinaryTree tree = new BinaryTree();
        Node Raiz = new Node("Pablo");
        Node Madre = new Node("Ana");
        Node Padre = new Node("Wilson");
        Node AbuelaPaterna = new Node("Rosa");
        Node BisAbuelaPM = new Node("");
        Node BisAbueloPM = new Node("");
        Node AbueloPaterno = new Node("Enrique");
        Node BisAbuelaPP = new Node("Marta");
        Node BisAbueloPP = new Node("Andrés");
        Node AbuelaMaterna = new Node("Eva");
        Node BisAbuelaMM = new Node("Sara");
        Node BisAbueloMM = new Node("Alberto");
        Node AbueloMaterno = new Node("Miguel");
        Node BisAbuelaMP = new Node("Sandra");
        Node BisAbueloMP = new Node("");
        tree.insertar(Raiz.data, "Hombre"); 
        tree.insertar(Madre.data, "mujer"); 
        tree.insertar(Padre.data, "Hombre");  
        tree.insertar(tree.root.right, AbuelaPaterna.data, "mujer");
        tree.insertar(tree.root.right.left, BisAbuelaPM.data, "Mujer");
        tree.insertar(tree.root.right.left, BisAbueloPM.data, "Hombre");        
        tree.insertar(tree.root.right, AbueloPaterno.data, "hombre");
        tree.insertar(tree.root.right.right, BisAbuelaPP.data, "Mujer");
        tree.insertar(tree.root.right.right, BisAbueloPP.data, "hombre");        
        tree.insertar(tree.root.left, AbuelaMaterna.data, "mujer");
        tree.insertar(tree.root.left.left, BisAbuelaMM.data, "Mujer");
        tree.insertar(tree.root.left.left, BisAbueloMM.data, "Hombre");      
        tree.insertar(tree.root.left, AbueloMaterno.data, "Hombre");
        tree.insertar(tree.root.left.right, BisAbuelaMP.data, "Mujer");
        tree.insertar(tree.root.left.right, BisAbueloMP.data, "Hombre");        
        System.out.println("Árbol 1: \n");
        Laboratorio5.dibujarArbol(tree);    
        System.out.println("Altura árbol 1: " + tree. maxheight());
        System.out.println(tree.buscar("Ana"));
        System.out.println(tree.buscar("Eva"));
        System.out.println(tree.buscar("X"));
        System.out.println("Abuela materna de " + Raiz.data + ": " + tree.getNomAbuela(Raiz.data));
    }
}
