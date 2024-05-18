package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String data;

    private List<Edge> edges;

    public Vertex(String data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Vertex end, int weight){
        edges.add(new Edge(this,end,weight));
    }

    public void removeEdge(Vertex end){
        edges.removeIf(edge -> edge.getEndVertex().equals(end));
    }

    public String getData() {
        return data;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void print(){
        String message="";

        if(this.edges.size()==0){
            System.out.println(this.data +" --> ");
            return;
        }
        message+=this.data;

        for(int i=0;i<edges.size();i++){
            message += " --> "+ edges.get(i).getEndVertex().data + " Kms : "+edges.get(i).getWeight();

            if(i!=edges.size()-1)
                message+=" ,";
        }

        System.out.println(message);
    }
}
