package Array;

import java.util.Arrays;
import java.util.Comparator;

// This is a hard problem and requirement is to find the no of swaps required to sort array
// Complexity of this algo is O(n2) but in large arrays this will be effective
public class MinSwaps {

    // This pair will maintain key and its indexes
    // keys will be used to sort the array
    // index will be used to find old position and finding loops using this
    static class Pair
    {
        public int key;
        public int index;

        Pair(int key, int index)
        {
            this.key = key;
            this.index = index;
        }
    }
    public static void main(String[] args) {
       // int arr[] = new int[]{3,2,1};
        int arr[] = new int[]{4,3,2,1,6};
        int minSwaps = findMinSwaps(arr);
        System.out.println(minSwaps);
    }

    private static int findMinSwaps(int []arr)
    {
        int result = 0;
        // create a array of pair
        Pair[] pairs = new Pair[arr.length];
        // initialize pairs
        for(int i=0;i<arr.length;i++)
        {
            pairs[i] = new Pair(arr[i],i);
        }
        // sort the pairs using key ---> O(nlogn)
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.key));

        // Maintain a array for finding visited nodes
        boolean[]visited = new boolean[arr.length];

        // Start finding cycles from start of array
        for(int i=0;i<arr.length;i++)
        {
            // find old position of current node
            int oldPosition = pairs[i].index;
            // if already visited or position not changed then continue
            if(visited[i] == true || i == oldPosition)
            {
                continue;
            }
            int node = i;
            int cycle = 0;
            // look for cycles
            while(visited[node] == false)
            {
                // mark node as visited so that loop breaks
                visited[node] = true;
                // next node in cycle will be the pair index of current node
                int nextNode = pairs[i].index;
                // set nextNode as current node
                node = nextNode;
                cycle+= 1;
            }
            // no of swaps will be 1 less than the cycles
            result+= cycle-1;
        }
        return result;
    }
}
