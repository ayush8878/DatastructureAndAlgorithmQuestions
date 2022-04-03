package Graph;

import java.util.*;

class Pair implements Comparable
{
    int weight;
    int node;

    public Pair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return weight == pair.weight;
    }

    @Override
    public int hashCode() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        Pair p = (Pair) o;
        return Integer.compare(this.weight,p.weight);
    }
}
public class GraphWithWeight {
    int V;
    List<List<Pair>> l;

    public GraphWithWeight(int v) {
        V = v;
        l = new ArrayList<>(V);
        for(int i = 0;i<V;i++)
        {
            l.add(i,new ArrayList<>());
        }
    }

    void addEdge(int i,int weight,int j,boolean undir)
    {
        l.get(i).add(new Pair(weight,j));
        if(undir)
        {
            l.get(j).add(new Pair(weight,i));
        }
    }

    void printAdjList()
    {
        // iterate over all rows
        for(int i=0;i<V;i++)
        {
            System.out.print(i+"--> ");
            // print every element of ith linked list
            for(Pair p:l.get(i))
            {
                System.out.print(p.node +"--["+p.weight +"]--> ");
            }
            System.out.println(" ");
        }
    }

    int dijkstra(int src,int dest)
    {
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        TreeSet<Pair> set = new TreeSet<Pair>();

        //init
        dist[src] = 0;
        set.add(new Pair(0,src));

        while(!set.isEmpty())
        {
            Iterator<Pair> it = set.iterator();
            Pair pr = it.next();
            int distanceTillNow = pr.weight;
            int node = pr.node;
            set.remove(pr);

            // iterate over adj of node
            for(Pair adjPair: l.get(node))
            {
                int weight = adjPair.weight;
                int nextNode = adjPair.node;

                if(distanceTillNow + weight < dist[nextNode])
                {
                    set.removeIf(p -> p.weight == weight && p.node == nextNode);
      //              set.remove(nextNode);
                }
                dist[nextNode] = distanceTillNow + weight;
                set.add(new Pair(dist[nextNode],nextNode));

            }
        }
        // single source the shortest dist to all
        for (int i = 0; i < V; i++) {
            System.out.println("Node "+i+" Dist "+dist[i]);
        }
        return dist[dest];
    }

    public static void main(String[] args) {
        /*GraphWithWeight graph = new GraphWithWeight(6);
        graph.addEdge(0,1,1,true);
        graph.addEdge(0,4,1,true);
        graph.addEdge(2,1,1,true);
        graph.addEdge(3,4,1,true);
        graph.addEdge(4,5,1,true);
        graph.addEdge(2,3,1,true);
        graph.addEdge(3,5,1,true);*/
        GraphWithWeight graph = new GraphWithWeight(5);
        graph.addEdge(0,1,1,true);
        graph.addEdge(1,2,2,true);
        graph.addEdge(0,4,2,true);
        graph.addEdge(0,7,3,true);
        graph.addEdge(3,2,2,true);
        graph.addEdge(3,3,4,true);
        graph.printAdjList();
        System.out.println(graph.dijkstra(0,4));
    }
}