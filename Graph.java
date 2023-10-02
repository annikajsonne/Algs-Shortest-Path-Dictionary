import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Graph {

	private HashMap<String, Vertex> graph;

	public Graph() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			File f = new File("Dict.txt");
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				words.add(s.nextLine());
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		graph = new HashMap<String, Vertex>();
		// adds each word as a vertex to alist as a linkedlist
		for (int i = 0; i < words.size(); i++) {
			graph.put(words.get(i), new Vertex(words.get(i)));
		}

		// add the edges
		// for each word, go through changing one letter and then if it is a word, add
		// it to the end of the list
		int dist = 0;
		for (int i = 0; i < words.size(); i++) {
			char[] key = words.get(i).toCharArray();
			Vertex v = graph.get(words.get(i));
			ArrayList<Edge> e = v.edges;
			for (int j = 0; j < key.length; j++) {
				for (char k = 'a'; k <= 'z'; k++) {
					char[] word = key.clone();
					word[j] = k;

					if (word[j] != key[j] && graph.containsKey(new String(word))) {
						Vertex w = graph.get(new String(word));
						int weight = findWeight(v.name, w.name);
						e.add(new Edge(w, weight));
						dist += weight;

					}
				}
			}

		}
		initialize(dist);
	}

	public int findWeight(String o1, String o2) {
		char[] w1 = o1.toCharArray();
		char[] w2 = o2.toCharArray();
		int ascii1 = 0;
		int ascii2 = 0;
		if (w1.equals(w2)) {
			return 0;
		}
		for (int i = 0; i < w1.length; i++) {
			if (w1[i] != w2[i]) {
				ascii1 = w1[i];
				ascii2 = w2[i];
			}
		}
		return Math.abs(ascii1 - ascii2);
	}

	public Vertex get(String key) {
		return graph.get(key);
	}

	public void initialize(int dist) {
		for (Vertex vertex : graph.values()) {
			vertex.d = dist;
		}
	}

	public void reinitialize() {
		int dist = 0;
		for (Entry<String, Vertex> entry : graph.entrySet()) {
			char[] key = entry.getKey().toCharArray();
			Vertex v = graph.get(new String(key));
			ArrayList<Edge> e = v.edges;
			for (int j = 0; j < key.length; j++) {
				for (char k = 'a'; k <= 'z'; k++) {
					char[] word = key.clone();
					word[j] = k;

					if (word[j] != key[j] && graph.containsKey(new String(word))) {
						Vertex w = graph.get(new String(word));
						int weight = findWeight(v.name, w.name);
						e.add(new Edge(w, weight));
						dist += weight;

					}
				}
			}

		}
		initialize(dist);
	}
	
	public boolean containsKey(String w) {
		return graph.containsKey(w);
	}
}
