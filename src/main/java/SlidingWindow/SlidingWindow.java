package SlidingWindow;

import java.util.*;
// incomplete
public class SlidingWindow
{
    public static void main(String arr[])
    {
      String daddy = "hello_world";
      String kid = "leo";
      String res = findKid(daddy,kid);
      System.out.println(res);
    }

    public static String findKid(String daddy, String kid)
    {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<kid.length();i++)
        {
            char ch = kid.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int start = 0;
        int end = 0;
        while(end < daddy.length())
        {

        }
      return null;
    }
}
