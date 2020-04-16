public class BinarySearchTree {

    Node root; 
  
    public BinarySearchTree() {  
        root = null;  
    } 
  
    public void insertar(int n) { 
       root = insertarAux(root, n); 
    } 
      
    public Node insertarAux(Node node, int n) { 
  
        if (node == null) { 
            node = new Node(n); 
            return node; 
        } 
  
        if (n < node.data) 
            node.left = insertarAux(node.left, n); 
        else if (n > node.data) 
            node.right = insertarAux(node.right, n); 
  
        return node; 
    } 
    
    public void search(int n) {
        searchAux(root, n);
    }
    
    public boolean searchAux(Node node, int n) { 
        if (node.data==n) 
            return true; 
        else if (node.data > n) {
            if (node == null) return false;
            searchAux(node.left, n); 
        }
        else {
            if (node == null) return false;
            searchAux(node.right, n); 
        }
        return false;
    } 
    
    public void inOrder()  { 
       inOrderAux(root); 
    } 
  
    public void inOrderAux(Node node) { 
        if (node != null) { 
            inOrderAux(node.left); 
            System.out.println(node.data); 
            inOrderAux(node.right); 
        } 
    } 
}
