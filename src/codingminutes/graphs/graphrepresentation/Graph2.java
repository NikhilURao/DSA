package codingminutes.graphs.graphrepresentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph2 {
	
	// Node representing a city
	public static class Node{
		String name;
		ArrayList<String> neighboring_cities; // adjacency list to maintain neighboring cities
		
		public Node(String name) {
			this.name = name;
			this.neighboring_cities = new ArrayList<>();
		}
	}
	
	// Representation of cities as a graph
	public static class Graph{
		// hashmap to store the mapping of city name and the pointer/ reference to the corresponding node
		HashMap<String, Node> hm;
		
		public Graph(ArrayList<String> cities) {
			this.hm = new HashMap<>();
			for (String city : cities) {
				this.hm.put(city, new Node(city));
			}
		}
		
        public void addEdge(String x, String y, boolean unDirected){
        	hm.get(x).neighboring_cities.add(y);
            if(unDirected){
                hm.get(y).neighboring_cities.add(x);
            }
        }

        public void printAdjList(){
            for(Map.Entry<String, Node> cityPair: hm.entrySet()){
                System.out.print(cityPair.getKey() + " --> ");
                for(String nbrs: cityPair.getValue().neighboring_cities){
                    System.out.print(nbrs + ", ");
                }
                System.out.println();
            }
        }
		
	}

	public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("London");
        cities.add("Paris");
        cities.add( "New York");

        Graph g = new Graph(cities);
        g.addEdge("Delhi", "London" , true);
        g.addEdge("New York","London", true);
        g.addEdge("Delhi","Paris" , true);
        g.addEdge("Paris","New York" , true);

        g.printAdjList();

	}

}
