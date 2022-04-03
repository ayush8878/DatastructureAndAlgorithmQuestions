package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Graph {
    // no of vertex in graph
    int V;
    // adj list of each vertex(considering vertex as index)
    List<List<Integer>> l;

    // When graph gets created add all nodes with empty adj
    public Graph(int v) {
        V = v;
        l = new ArrayList<>(V);
        for(int i = 0;i<V;i++)
        {
            l.add(i,new ArrayList<>());
        }
    }

    /**
     * This method will add an edge depending on undir flag
     * @param i
     * @param j
     * @param undir
     */
    void addEdge(int i,int j,boolean undir)
    {
        l.get(i).add(j);
        if(undir)
        {
            l.get(j).add(i);
        }
    }

    /**
     * This method will print breadth first traversal of Graph
     * @param source
     */
    void bfs(int source)
    {
        // Consider an Array Deque for this operation in which you can keep un-traversed nodes
        ArrayDeque<Integer> deque = new ArrayDeque();
        // this array will maintain visited status of boolean array
        boolean[] visited = new boolean[V];
        // push source on queue
        deque.addLast(source);
        // marking source as visited
        visited[source]=true;
        // traverse while queue is not empty
        while(!deque.isEmpty())
        {
            // pop the front of queue
            int front = deque.removeFirst();
            // Print traversal
            System.out.print(front+"-->");
            // check for all adj nodes
            for(int adj:l.get(front))
            {
                if(!visited[adj])
                    {
                        deque.addLast(adj);
                        // marking front of queue as visited
                        visited[adj]=true;
                    }
            }
        }
    }

    /**
     * This method will print the shortest path using breadth first traversal of Graph
     * @param source
     */
    void shortestPathFromSource(int source)
    {
        // Consider an Array Deque for this operation in which you can keep un-traversed nodes
        ArrayDeque<Integer> deque = new ArrayDeque();
        // this array will maintain visited status of boolean array
        boolean[] visited = new boolean[V];
        // distance array
        int[] distance = new int[V];

        // parent array
        int[] parent = new int[V];

        // initialize parent with -1
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        // push source on queue
        deque.addLast(source);
        // marking source as visited
        visited[source]=true;

        // update parent for source
        parent[source] = source;
        distance[source] = 0;

        // traverse while queue is not empty
        while(!deque.isEmpty())
        {
            // pop the front of queue
            int front = deque.removeFirst();
            // check for all adj nodes
            for(int adj:l.get(front))
            {
                if(!visited[adj])
                {
                    deque.addLast(adj);
                    // update parent and distance for adj
                    parent[adj] = front;
                    distance[adj] = distance[front] + 1;
                    // marking front of queue as visited
                    visited[adj]=true;
                }
            }
        }
        // print the shortest distance
        for (int i = 0; i < V; i++)  {
            System.out.println("Shortest distance to "+i+" is "+distance[i]);
        }

    }

    /**
     * This method will print the shortest path using breadth first traversal of Graph
     * @param source
     */
    int shortestPathFromSource(int source,int dest,int weight)
    {
        // Consider an Array Deque for this operation in which you can keep un-traversed nodes
        ArrayDeque<Integer> deque = new ArrayDeque();
        // this array will maintain visited status of boolean array
        boolean[] visited = new boolean[V];
        // distance array
        int[] distance = new int[V];

        // parent array
        int[] parent = new int[V];

        // initialize parent with -1
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        // push source on queue
        deque.addLast(source);
        // marking source as visited
        visited[source]=true;

        // update parent for source
        parent[source] = source;
        distance[source] = 0;

        // traverse while queue is not empty
        while(!deque.isEmpty())
        {
            // pop the front of queue
            int front = deque.removeFirst();
            // check for all adj nodes
            for(int adj:l.get(front))
            {
                if(!visited[adj])
                {
                    deque.addLast(adj);
                    // update parent and distance for adj
                    parent[adj] = front;
                    distance[adj] = distance[front] + 1;
                    // marking front of queue as visited
                    visited[adj]=true;
                }
            }
        }
        // print the path from a source to any destination
        int shortestPathLength = 0;
        if(dest != -1)
        {
            int temp = dest;
            while (temp != source)
            {
                shortestPathLength+=weight;
                System.out.print(temp+"-->");
                temp = parent[temp];
            }
            System.out.println(source);
        }
       return weight;
    }

    void printAdjList()
    {
        // iterate over all rows
        for(int i=0;i<V;i++)
        {
            System.out.print(i+"--> ");
            // print every element of ith linked list
            for(int j:l.get(i))
            {
                System.out.print(j+"--> ");
            }
            System.out.println(" ");
        }
    }

    int shortestPathFromSource(int source,int dest)
    {
        return shortestPathFromSource(source,dest,0);
    }

    /**
     * This method will print depth first search of given graph starting with provided source
     * @param source
     */
    void dfs(int source)
    {
        // this array will maintain visited status of boolean array
        boolean[] visited = new boolean[V];

        // This is used for maintaining recursion , could have been avoided if visited array was coming from main
        dfsHelper(source,visited);

    }

    /**
     * This method will recursively perform deapth first search for provided node
     * @param node
     * @param visited
     */
    private void dfsHelper(int node, boolean[] visited) {
        // mark node as visited
        visited[node] = true;
        // print node
        System.out.print(node+"-->");
        // for each adj node check if there are adj nodes that are not visited yet
        for(int neighbour : l.get(node))
        {
            if(!visited[neighbour])
            {
                // recursively call for neighbours
                dfsHelper(neighbour,visited);
            }

        }
    }

    /**
     * This method finds deapth first seach for a graph returning true if found a cycle
     * @param node
     * @param visited
     * @param parent
     * @return
     */
    boolean dfs(int node,boolean[] visited,int parent)
    {
        visited[node] = true;

        for(int adj:l.get(node))
        {
            if(!visited[adj])
            {
                // for adj node find cycles
                boolean adjFoundCycle = dfs(adj,visited,node);
                if(adjFoundCycle) return true;
            }
            // if adj node is not parent that is visited then return true
            else if(adj!=parent)
            {
                return true;
            }
        }
      return false;
    }

    /**
     * This method checks if there exists a cycle
     * @return
     */
    void containsCycle()
    {
        // this array will maintain visited status of boolean array
        boolean[] visited = new boolean[V];
        System.out.println(dfs(0,visited,-1));
    }

    /* TODO: Find Cycle using BFS */

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,1,true);
        graph.addEdge(0,4,true);
        graph.addEdge(2,1,true);
        graph.addEdge(3,4,true);
        graph.addEdge(4,5,true);
        graph.addEdge(2,3,true);
        graph.addEdge(3,5,true);
        graph.printAdjList();
        // graph.shortestPathFromSource(0);
        // graph.shortestPathFromSource(0,3);
        //graph.dfs(0);
        graph.containsCycle();
    }
}