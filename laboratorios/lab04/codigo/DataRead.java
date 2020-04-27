import java.util.*;
import java.io.*;

public class DataRead {
    ArrayList<String> f = new ArrayList<>();
    String directName;
    String name;
    String size;
    String user;
    Node directory;
    Node d = new Node(name, size, user);
    Node fi = new Node(name, size, directory, user);
    
    public void readFile() throws FileNotFoundException{
        File t = new File("ejemplito.txt");
        Scanner l = new Scanner(t); 
        directName = l.nextLine();
        int space1 = 0;
        int space2 = 0;
        String[] arr = new String[2];
        Node actDirectory = new Node(name, size, user);
        Node file;
        while(l.hasNextLine()) {
            String temp = l.nextLine();
            name = "";
            size = "";
            boolean isFile = false;
            user = "";
                
            space1 = temp.indexOf('[') + 1;
            space2 = temp.indexOf(']');
            
            String temp2 = temp.substring(space1, space2);
            arr = temp2.split(" ");
            String temp3 = temp.substring(space2 + 2, temp.length());
            name = temp3;
            user = arr[0];
            size = arr[1];
                
            for(int i = 0; i < name.length(); i++) {
                if(name.charAt(i) == '.') isFile = true;
            }
                
            if(!isFile) {
                name = directName + name;
                actDirectory = new Node(name, size, user);
                d.addArr(actDirectory);
            } else {
                file = new Node(name, size, actDirectory, user);
                fi.addArr(file);
            }
        }
    }
}
