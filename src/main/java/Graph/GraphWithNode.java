package Graph;

import java.util.*;

class Node {
    String name;
    List<String> adj = new ArrayList<>();

    Node(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", adj=" + adj +
                '}';
    }
}

public class GraphWithNode
{
    Map<String,Node> adjKeyMap = new HashMap<>();

    public GraphWithNode(List<String> cities) {
        for(String city:cities)
        {
            adjKeyMap.put(city, new Node(city));
        }
    }

    void addEdge(String x, String y,boolean isUndir)
    {

        adjKeyMap.get(x).adj.add(y);
        if(isUndir)
        {
            adjKeyMap.get(y).adj.add(x);
        }
    }

    private void print() {
        for(String s: adjKeyMap.keySet())
        {
            System.out.println(adjKeyMap.get(s));
        }
    }

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Delhi","London","Paris","New York");
        GraphWithNode graph = new GraphWithNode(cities);

        graph.addEdge("Delhi","London",false);
        graph.addEdge("New York","London",false);
        graph.addEdge("Delhi","Paris",false);
        graph.addEdge("Paris","New York",false);
        graph.print();

    }
}
