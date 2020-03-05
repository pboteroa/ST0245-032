package taller7;
import java.lang.IndexOutOfBoundsException;

public class Punto1y2 {

    Node first;
    private int size;

    public Punto1y2() {
        size = 0;
        first = null;
    }
    
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
    
    public int size() {
        return size;
    }
    
    public void insert(int data, int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            Node nuevo = new Node(data);
            nuevo.next = getNode(0);
            first = nuevo;
            size++;
        } 
        else if(index != 0){
            Node temp = getNode(index - 1);
            Node nuevo = new Node(data);
            nuevo.next = temp.next;
            temp.next = nuevo;
            size++;
        }
        else {
        	throw new IndexOutOfBoundsException();
        }
    }
    
    public void remove(int index) {
        try {
            if (index == 0) {
                Node temp = first;
                first = temp.next;
                size--;
            } 
            else if (index == size - 1) {
                Node temp = getNode(size - 2);
                temp.next = null;
                size--;
            } 
            else {
                Node temp = getNode(index - 1);
                temp.next = temp.next.next;
                size--;
            }
        } 
        catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }

    }

    //Punto 2 
    public boolean contains(int data) {
        try {
            for (int i = 0; i < size; i++) {
                if (get(i) == data) {
                    return true;
                }
            }
        } 
        catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }
        return false;
    }
}
