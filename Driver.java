import java.util.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter starting word: ");
		String start = keyboard.nextLine();
		System.out.println("Enter ending word: ");
		String end = keyboard.nextLine();
		
		dijkstrasAlg(g, start, end);
		System.out.println("Would you like to find another path? Enter Y for yes, N for no.");
		String cont = keyboard.nextLine();
		while(!cont.equals("N")) {
			System.out.println("Enter starting word: ");
			start = keyboard.nextLine();
			System.out.println("Enter ending word: ");
			end = keyboard.nextLine();
			dijkstrasAlg(g, start, end);
			
			System.out.println("Would you like to find another path? Enter Y for yes, N for no.");
			cont = keyboard.nextLine();
		}
		
	}

	public static void dijkstrasAlg(Graph g, String start, String end) {
		if(!g.containsKey(start) || !g.containsKey(end)) {
			System.out.println("The start and end words must be in the dictionary");
			return;
		}
		if(start.length() != end.length()) {
			System.out.println("The start and end words must be the same length.");
			return;
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		Vertex vertex = g.get(start);
		vertex.d = 0;
		pq.add(vertex);
		Vertex current = null;
		
		do{
			current = pq.poll();
			// all edges of start are put in a priority queue
			for (int i = 0; i < current.edges.size(); i++) {
				Vertex v = current.edges.get(i).v;
				if (v.d > (current.d + current.edges.get(i).weight)) {
					v.d = current.edges.get(i).weight + current.d;
					v.pre = current;
					pq.remove(v);
					pq.add(v);
				}
			}
		} while (!current.name.equals(end) && !pq.isEmpty());
		
		Vertex c = g.get(end);
		int length = 0;
		while(!(c == g.get(start))) {
			if(c == null) {
				System.out.println("No path found");
				return;
			}
			System.out.print(c.name + " < ");
			c = c.pre;
			length++;
		}
		
		System.out.println(start);
		System.out.println("Length: " + length);
		
		g.reinitialize();
	}

}
