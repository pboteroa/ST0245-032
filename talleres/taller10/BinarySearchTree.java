package taller10;

public class BinarySearchTree {

    private Node root;
 
  
   public BinarySearchTree() {
       this.root = null;
   }

   public BinarySearchTree(int n) {
       this.root = new Node(n);
   }

   public void insertar(int n) {
       insertarAux(root, n);
   }

   private void insertarAux(Node node, int n) {
       if (node.data == n){
           return;
       }else if (n > node.data) {
           if (node.right == null) {
               node.right = new Node(n);
           }else {
               insertarAux(node.left , n);
           }
       }else {
           if (node.left == null) {
               node.left = new Node(n);
           }else {
               insertarAux(node.right, n);
           }
       }
   }
 
   public boolean buscar(int n) {
       return buscarAux(root, n);
   }
   
 
   private boolean buscarAux(Node node, int n) {
       if (node.data == n) {
           return true;
       }
       if (n > node.data) {
           return buscarAux(node.right, n);
       }
       return buscarAux(node.left, n);
   }


}