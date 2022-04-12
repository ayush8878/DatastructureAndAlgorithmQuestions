package Hashing;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*Issue with output*/
class Pair implements Comparable<Pair>
{
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (x != pair.x) return false;
        return y == pair.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.x == p.x)
        {
            return this.y - p.y;
        }
        return this.x - p.x;
    }
}
public class CountingRectangles {
    public static void main(String[] args) {
        Pair[] arr =
                {
                  new Pair(4,1)
                , new Pair(4,0)
                , new Pair(0,0)
                , new Pair(0,1)
                , new Pair(1,1)
                , new Pair(1,0)
                , new Pair(2,0)
                , new Pair(2,1)
                };
        System.out.println(findRectanglesCount(arr));
    }

    private static int findRectanglesCount(Pair[] arr) {
        Set<Pair> pairs = new TreeSet<>();
        int count = 0;
        for(Pair pair:arr)
        {
            pairs.add(pair);
        }
        Iterator<Pair> iterator1 = pairs.iterator();
        Iterator<Pair> iterator2 = pairs.iterator();
        while (iterator1.hasNext())
        {
            Pair p1 = iterator1.next();
            if(!iterator1.hasNext())
            {
                break;
            }
            while (iterator2.hasNext())
            {
                Pair p2 = iterator2.next();
                if(p2.x == p1.x || p2.y == p1.y)
                {
                    continue;
                }
                Pair p3 = new Pair(p1.x, p2.y);
                Pair p4 = new Pair(p2.x,p1.y);

                // lookup
                if(pairs.contains(p3) && pairs.contains(p4))
                {
                    count++;
                }
            }
        }
        return count;
    }
}
