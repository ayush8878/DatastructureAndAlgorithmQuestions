package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountingTriangles {
    public static void main(String[] args) {
        Pair[] arr =
                {
                          new Pair(1,2)
                        , new Pair(2,1)
                        , new Pair(2,2)
                        , new Pair(2,3)
                        , new Pair(3,2)
                };
        System.out.println(findTriangleCount(arr));
    }

    private static int findTriangleCount(Pair[] pairs) {
        // these map will store frequencies of X and Y
        Map<Integer,Integer> freqX = new HashMap<>();
        Map<Integer,Integer> freqY = new HashMap<>();

        // iterate over pairs and update frequency
        for(Pair pair:pairs)
        {
            int x = pair.x;
            int y = pair.y;
            freqX.put(x,freqX.getOrDefault(x,0)+1);
            freqY.put(y,freqY.getOrDefault(y,0)+1);
        }

        // count
        int count = 0;
        for(Pair pair:pairs)
        {
            int x = pair.x;
            int y = pair.y;

            int fX = freqX.get(x);
            int fY = freqX.get(y);

            count += (fX - 1) * (fY -1);
        }
        return count;
    }
}
