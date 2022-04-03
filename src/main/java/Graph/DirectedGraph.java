package Graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {
    int V;
    List<List<Integer>> l;

    public DirectedGraph(int v) {
        V = v;
        l = new ArrayList<>(V);
        for(int i=0;i<v;i++)
        {
            l.add(new ArrayList<>());
        }
    }
    void addEdge(int i,int j)
    {
      l.get(i).add(j);
    }

    /**
     *  return true if back-edge is found otherwise false
     * @param source
     * @param visited
     * @param stack
     * @return
     */
    boolean dfs(int source,boolean[] visited,boolean[] stack)
    {
        // arrived at node
        visited[source] = true;
        stack[source]  = true;

        // perform task to find back-edge
        for(int adj:l.get(source))
        {
            // if adj is already visited and present in stack
            if(stack[adj]==true)
            {
                return true;
            }
            //when adj is not visited check cycles for adj
            else if(visited[adj]==false)
            {
                boolean adjFoundCycle = dfs(adj,visited,stack);
                if(adjFoundCycle)
                {
                    return true;
                }
            }
        }

        // going back
        stack[source] = false;
        return false;
    }

    /**
     * This method will find cycles in directed graph
     * With directed graph edge is not present for every node so we need to check one by one
     * every node as source and find if there is a back-edge
     * @return
     */
    boolean containsCycle()
    {
        boolean[] visited = new boolean[V];
        // this stack will maintain nodes visited for current source
        boolean[] stack = new boolean[V];

        // for each node look for back-edge
        for(int i=0;i<V;i++)
        {
            int source = i;
            // when current source not visited
            if(!visited[source])
            {
                // check dfs for current node
                if(dfs(source,visited,stack))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(3);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        System.out.println(graph.containsCycle());
    }
}
