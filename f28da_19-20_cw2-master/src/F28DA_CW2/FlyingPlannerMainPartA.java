package F28DA_CW2;

import java.util.Scanner;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleGraph;

public class FlyingPlannerMainPartA {

	public static void main(String[] args) {
		
		// The following code is from HelloJGraphT.java of the org.jgrapth.demo package
		
		System.err.println("The example code is from HelloJGraphT.java from the org.jgrapt.demo package.");
		System.err.println("Use similar code to build the small graph from Part A by hand.");
		System.err.println("Note that you will need to use a different graph class as your graph is not just a Simple Graph.");
		System.err.println("Once you understand how to build such graph by hand, move to Part B to build a more substantial graph.");
		// Code is from HelloJGraphT.java of the org.jgrapth.demo package (start)
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        String v1 = "Edinburgh";
        String v2 = "Heathrow";
        String v3 = "Dubai";
        String v4 = "Kuala Lumpur";
        String v5 = "Syndey";

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);

        // Creating edges(i.e. routes)
        // And giving them a weight (i.e. price)
        DefaultWeightedEdge r1 = g.addEdge(v1,v2);
        g.setEdgeWeight(r1, 80);
        
        DefaultWeightedEdge r2 = g.addEdge(v2,v3);
        g.setEdgeWeight(r2,130);
        
        DefaultWeightedEdge r3 = g.addEdge(v2,v5);
        g.setEdgeWeight(r3, 570);
        
        DefaultWeightedEdge r4 = g.addEdge(v3,v4);
        g.setEdgeWeight(r4, 170);
        
        DefaultWeightedEdge r5 = g.addEdge(v3,v1);
        g.setEdgeWeight(r5, 190);
        
        DefaultWeightedEdge r6 = g.addEdge(v4,v5);
        g.setEdgeWeight(r6, 150);
        
        
        //same but backwards

        DefaultWeightedEdge r7 = g.addEdge(v2,v1);
        g.setEdgeWeight(r7, 80);
        
        DefaultWeightedEdge r8 = g.addEdge(v3,v2);
        g.setEdgeWeight(r8,130);
        
        DefaultWeightedEdge r9 = g.addEdge(v5,v2);
        g.setEdgeWeight(r9, 570);
        
        DefaultWeightedEdge r10 = g.addEdge(v4,v3);
        g.setEdgeWeight(r10, 170);
        
        DefaultWeightedEdge r11 = g.addEdge(v1,v3);
        g.setEdgeWeight(r11, 190);
        
        DefaultWeightedEdge r12 = g.addEdge(v5,v4);
        g.setEdgeWeight(r12, 150);
        
        
        // Display used airports
        System.out.println(g.vertexSet());
        // add scanner, to get user input
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter starting point: ");
        String sp = s1.nextLine();
        System.out.print("Enter destination: ");
        String dst = s1.nextLine();
        
        //using Dijktras Shortest path, get shortest path between chosen airports
        //display the Shortest path's weight (i.e. price)
        GraphPath<String, DefaultWeightedEdge> cheapestRoute = DijkstraShortestPath.findPathBetween(g,sp,dst);
        System.out.println("£" + cheapestRoute.getWeight());
        
              
	}

}
