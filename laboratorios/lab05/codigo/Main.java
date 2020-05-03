import java.util.*;

public class Main {
    public static void main() {
        DataRead d = new DataRead();
        HashMap<Long, Node> vertex = d.readVertex();
        System.out.println(vertex.size());
        ArrayList<Triplet<Long, Long, Double>> edges = d.readEdges();
        System.out.println(edges.size());
        DataStructure e = new DataStructure(vertex, edges);
        System.out.println(e.adjGraph.size());
        System.out.println(vertex.get(new Long(287291920)).id);
        
        Long l = new Long(287291920);
        Long l2 = new Long(1397149003);
        
        ArrayList<Long> test1 = e.getSuccessors(l);
        System.out.println(test1.size());
        
        for(Long i : test1) {
            System.out.println(i);
        }
        System.out.println("Distance: " + e.getDistance(l, l2));
    }
}