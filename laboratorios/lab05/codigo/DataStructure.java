import java.util.*;

public class DataStructure {

    ArrayList<Triplet<Node, Node, Double>> adjGraph = new ArrayList<>();
    
    public DataStructure (HashMap<Long, Node> vertex, ArrayList<Triplet<Long, Long, Double>> edges) {
        for(Triplet<Long, Long, Double> t : edges) {
            Triplet<Node, Node, Double> triplet = new Triplet(new Node(t.getFirst()), new Node(t.getSecond()), t.getDistance());
            adjGraph.add(triplet);
        }
    }
    
    public ArrayList<Long> getSuccessors (Long Vid) {
        ArrayList<Long> successors = new ArrayList<>();
        
        for(int i = 0; i < adjGraph.size(); i++) {
            Triplet<Node, Node, Double> t = adjGraph.get(i);
            if(Vid == adjGraph.get(i).getFirst().id) {
                successors.add(adjGraph.get(i).getSecond().id);
            }
        }
        
        return successors;
    }
    
    public Double getDistance(Long sourceID, Long destinationID){
        for(int i=0; i < adjGraph.size(); i++){
            if((sourceID == adjGraph.get(i).getFirst().id) && (destinationID == adjGraph.get(i).getSecond().id)){
                return adjGraph.get(i).getDistance();
            }
        }
        return -1.0;
    }
}