package javafx.util;

public class Pair<F, S> {
	
	public final F first;
	public final S second;

	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}
	
	public String toString() {
		return "Pair{" + String.valueOf(first) + " " + String.valueOf(second) + "}";
	}

}
