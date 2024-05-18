package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphTraverser {

    public static void graphDFT(Vertex start, List<Vertex> visitedVertex){
        System.out.println(start.getData());
        for(Edge e: start.getEdges()){
            Vertex neighbor = e.getEndVertex();
            if(!visitedVertex.contains(neighbor)){
                visitedVertex.add(neighbor);
                graphDFT(neighbor,visitedVertex);
            }
        }
    }

    public static void main(String[] args) {
        Graph testGraph= new Graph(true,true);
        testGraph.intializeGraph(testGraph);
        graphDFT(testGraph.getVertices().get(0),new ArrayList<>());
    }
}
