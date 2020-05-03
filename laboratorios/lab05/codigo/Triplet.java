public class Triplet<a, b, c> {

    private final a first;
    private final b second;
    private final c dist;

    public Triplet(a first, b second, c dist) {
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
    
    public a getFirst() {
        return first;
    }
    
    public b getSecond() {
        return second;
    }
    
    public c getDistance() {
        return dist;
    }
}