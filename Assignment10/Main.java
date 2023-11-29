package Assignment10;

public class Main {
public static void main(String args[])
    {
        //create a graph object and add edges to it
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        //print the DFS Traversal sequence
        System.out.println("A. Depth First Traversal for given graph"+
        "(with 0 as starting vertex)");
        g.DFS(0);
        System.out.println();

        System.out.println("B. Alter your output to 1,2,3,4 by changing the starting vertex to 1");
        g.addEdge(1, 4);
        g.DFS(1);
        System.out.println();


        Graph newGraph = new Graph(4);
        newGraph.addEdge(1, 1);
        newGraph.addEdge(1, 2);
        newGraph.addEdge(1, 3);
        System.out.println("Alter your output to 1,2,3 by reducing the number of vertices");
        newGraph.DFS(1);
        System.out.println();
    }
}