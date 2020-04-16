public class Main {
    
    public static void main(String[] args) { 
        BinarySearchTree tree = new BinarySearchTree(); 

        tree.insertar(50); 
        tree.insertar(30); 
        tree.insertar(20); 
        tree.insertar(40); 
        tree.insertar(70); 
        tree.insertar(60); 
        tree.insertar(80); 
  
        tree.inOrder(); 
    } 
}
