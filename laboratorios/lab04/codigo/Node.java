import java.util.*;

public class Node {
    String name;
    Node directory;
    String size;
    String user;
    ArrayList<Node> arr = new ArrayList<>();
    
    public Node (String name, String size, Node directory, String user) {
        this.name = name;
        this.size = size;
        this.directory = directory;
        this.user = user;
    }   
    
    public Node (String name, String size, String user) {
        this.name = name;
        this.size = size;
        this.user = user;
    }   
    
    public void addArr(Node n) {
        arr.add(n);
    }
}