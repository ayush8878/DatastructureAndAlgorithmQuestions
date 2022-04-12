package SlidingWindow;

import java.util.*;
public class LongestUniqueSubstring
{
    public static void main(String args[])
    {
        String str = "prateekbhaiya";
        System.out.print(findLongestUniqueSubstring(str));
    }

    private static String findLongestUniqueSubstring(String str) {
        int start = 0;
        int end=0;
        int max = 0;
        int maxStart = 0;
        Set<Character> set = new HashSet<>();
        while(end < str.length())
        {
            if(set.contains(str.charAt(end)))
            {
                set.remove(str.charAt(start));
                start++;
            }
            else
            {
                set.add(str.charAt(end));
                if((end-start)+1>max)
                    maxStart=start;
                max = Math.max(max,(end-start)+1);
                end++;
            }
        }
        return str.substring(maxStart,maxStart+max);
    }
}
