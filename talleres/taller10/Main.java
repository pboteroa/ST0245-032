package taller10;

class Main {
	
	public static void main(String[] args) {
		
		BinarySearchTree arbol = new BinarySearchTree(4);
		arbol.insertar(2);
		arbol.insertar(5);
		arbol.insertar(7);
		arbol.insertar(6);

	    boolean bool = arbol.buscar(6);
	    bool = arbol.buscar(6);
	    System.out.println(bool);
	    
	  }
}
