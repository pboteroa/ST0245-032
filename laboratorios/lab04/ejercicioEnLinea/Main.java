public class Main {
    
    public static void main(String[] args) { 
        BinarySearchTree tree = new BinarySearchTree(); 

        tree.insertar(50); 
        tree.insertar(30); 
        tree.insertar(24); 
        tree.insertar(5); 
        tree.insertar(28); 
        tree.insertar(45); 
        tree.insertar(98); 
        tree.insertar(52); 
        tree.insertar(60); 
  
        tree.postOrder(); 
    } 
}