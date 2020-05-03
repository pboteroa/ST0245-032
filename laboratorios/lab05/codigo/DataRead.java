import java.util.*;
import java.io.*;
import java.lang.Object;

public class DataRead {
    public HashMap<Long, Node> readVertex() {
        BufferedReader br = null;
        HashMap<Long, Node> vertex = new HashMap<>();
        
        try {
            br = new BufferedReader(new FileReader("Vertices.txt"));
            String line;
                    
            while((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                Long id = Long.parseLong(arr[0]);
                Node v = new Node(id);
                vertex.put(v.id, v);
            }
            
            br.close();
        } catch (IOException e)  {
            System.out.println("Your file couldn't be found");
        }
        
        return vertex;
    }
    public ArrayList<Triplet<Long, Long, Double>> readEdges() {
        ArrayList<Triplet<Long, Long, Double>> edges = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Arcos.txt"));
            String line;
            
            while((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                Long origin = Long.parseLong(arr[0]);
                Long destination = Long.parseLong(arr[1]);
                Double dist = Double.parseDouble(arr[2]);
                Triplet<Long, Long, Double> t = new Triplet(origin, destination, dist);
                edges.add(t);
            }
            
            br.close();
        } catch (IOException e)  {
            System.out.println("Your file couldn't be found");
        }
        
        return edges;
    }
}
