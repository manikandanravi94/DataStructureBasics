package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Graph {

    private List<Vertex> vertices;

    private boolean isWeighted;

    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public Vertex addVertex(String data) {
        Vertex vertex = new Vertex(data);
        vertices.add(vertex);
        return vertex;
    }

    public void addEdge(Vertex startV, Vertex endV, int weight) {
        startV.addEdge(endV, weight);
    }

    public void removeEdge(Vertex startV, Vertex endV) {
        startV.removeEdge(endV);
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public Optional<Vertex> getVertexByValue(String data){
        return this.vertices.stream().filter(vertex -> vertex.getData().equals(data)).findFirst();
    }

    public void print(){
        this.vertices.forEach(Vertex::print);
    }

    public static void main(String[] args) {
        Graph tnBusStandGraph = new Graph(true, true);
//         Graph bglrStand = new Graph(true,true);
        Vertex cbeVertex = tnBusStandGraph.addVertex("cbe");
        Vertex chennaiVertex = tnBusStandGraph.addVertex("chennai");
        Vertex bglrVertex = tnBusStandGraph.addVertex("bangalore");
        tnBusStandGraph.addEdge(cbeVertex,chennaiVertex,500);
        tnBusStandGraph.addEdge(cbeVertex,bglrVertex,350);
        tnBusStandGraph.addEdge(bglrVertex,chennaiVertex,400);
        tnBusStandGraph.print();
    }

    private Graph testGraph;

    public void intializeGraph(Graph graph){
        testGraph = graph;
        Vertex startNode = testGraph.addVertex("0.0.0");
        Vertex v1=testGraph.addVertex("1.0.0");
        Vertex v2=testGraph.addVertex("2.0.0");
        Vertex v11=testGraph.addVertex("1.1.0");
        Vertex v12=testGraph.addVertex("1.2.0");
        Vertex v21=testGraph.addVertex("2.1.0");
        Vertex v111=testGraph.addVertex("1.1.1");
        Vertex v112 = testGraph.addVertex("1.1.2");
        Vertex v121=testGraph.addVertex("1.2.1");
        Vertex v211=testGraph.addVertex("2.1.1");
        testGraph.addEdge(startNode,v1,5);
        testGraph.addEdge(startNode,v2,10);
        testGraph.addEdge(v1,v11,15);
        testGraph.addEdge(v1,v12,20);
        testGraph.addEdge(v2,v21,12);
        testGraph.addEdge(v11,v111,14);
        testGraph.addEdge(v11,v112,16);
        testGraph.addEdge(v12,v121,44);
        testGraph.addEdge(v21,v211,33);
        testGraph.addEdge(v211,v2,11);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }
}
