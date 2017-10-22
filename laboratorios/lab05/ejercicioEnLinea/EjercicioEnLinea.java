import java.util.*;
import java.io.*;
public class BinaryTreeLinea
{
 Node root ;
 public BinaryTreeLinea () {
     root = null ;
 }
 
 public void insert(int x) {
     root= insert(root,x);
 }
 
 public boolean search(int x) {
    return search(root,x);
 }
 
 public void delete(int x){
    root= delete (root,x);
 }
 
 

private Node insert(Node nodo, int x){ 
    if(nodo == null){
        Node nodoO = new Node(x);
        nodo = nodoO;
        return nodo;
    }
    if(nodo.data<=x){
            nodo.right = insert(nodo.right,x);
            return nodo;
    }else{
            nodo.left = insert(nodo.left,x);
            return nodo;
        }
}

private Node delete(Node nodo, int x){
    if(nodo.data == x){
        Node nodoDer = Der(nodo.left);
        nodoDer.right = nodo.right;
        nodo = nodo.left;
        return nodo;
    }else{
        if(nodo.data<=x){
            nodo.left = delete(nodo.left,x);    
            return nodo;
        }else{
            nodo.right = delete(nodo.right,x);
            return nodo;
        }
    }
}

private Node Der(Node nodo){
    if(nodo.right == null){
        return nodo;
    }else{
        return Der(nodo.right);
    }
}

private void recursivePosorder(Node node){
    if(node != null){
        recursivePosorder(node.left);
        recursivePosorder(node.right);
        System.out.println(node.data);
    }
}

public void recursivePosO(){
    recursivePosorder(root);
}
private boolean search (Node nodo, int x){ 
    if(nodo ==null){
        return false;
    }
    if(x==nodo.data){
        return true;
    }
    if(nodo.data<=x){
        return search(nodo.left,x); 
    }else{
       return search(nodo.right,x);
    }
}

public static void main(){
    Scanner sc = new Scanner(System.in);
    BinaryTreeLinea tree = new BinaryTreeLinea();   
    System.out.println("Para finalizar el programa use el número -1");
    boolean s = true;
    while(s){
        int num = Integer.parseInt(sc.nextLine());
        if(num!= -1){ 
        tree.insert(num);
    }else{
        break;
    }
    }

    tree.recursivePosO();
}
}
