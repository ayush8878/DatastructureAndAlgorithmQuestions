package Graph;

import java.util.ArrayList;
import java.util.List;

public class ShakeAndLadder {
    public static void main(String[] args) {
        List<Pair> snakes = new ArrayList<>();
        snakes.add(new Pair(2,11));
        List<Pair> ladders = new ArrayList<>();
        ladders.add(new Pair(12,4));
        int minDice = minDiceThrows(16, snakes, ladders);
        System.out.println(minDice);
    }

    static int minDiceThrows(int n, List<Pair> snakes,List<Pair> ladders)
    {
        int[] board = new int[n+1];
        for(Pair p:snakes)
        {
            int s = p.weight;;
            int e = p.node;
            board[s] = e - s;
        }

        for(Pair p:ladders)
        {
            int s = p.weight;;
            int e = p.node;
            board[s] = e - s;
        }

        Graph graph = new Graph(n+1);
        for (int u = 0; u < n; u++) {
            for (int dice = 0; dice <= 6; dice++) {
                int v = u + dice;
                if(v >= board.length)
                    break;
                v += board[v];
                if(v<=n)
                {
                    graph.addEdge(u,v,false);
                }
            }
        }
        return graph.shortestPathFromSource(1,n+1,1);
    }
}
