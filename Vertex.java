import java.util.ArrayList;
import java.util.Comparator;

public class Vertex implements Comparable<Vertex> {
	
	String name;
	ArrayList<Edge> edges;
	Vertex pre;
	int d;
	
	public Vertex(String n) {
		this.name = n;
		this.edges = new ArrayList<Edge>();
		pre = null;
	}
	
	public int size() {
		return edges.size();
	}
	
	public Vertex get() {
		return this;
	}

	@Override
	public int compareTo(Vertex o) {
		
		return this.d - o.d;
	}
	
}
