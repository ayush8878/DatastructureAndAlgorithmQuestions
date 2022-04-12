package Hashing;

import java.util.HashSet;

public class FindCommon {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(7);
        set1.add(2);
        set1.add(8);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(6);
        set2.add(5);
        set2.add(3);
        set2.add(1);
        for(int x:set1)
        {
            System.out.println(x+" is Common - "+set2.contains(x));
        }
    }
}
