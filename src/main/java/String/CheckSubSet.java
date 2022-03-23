package String;

import java.util.HashMap;

public class CheckSubSet {

    public static void main(String[] args) {
        String s1 = "codingminutes";
        String s2 = "cines";
        System.out.println(checkSubset(s1,s2));

    }

    private static boolean checkSubset(String s1,String s2)
    {
        HashMap<Character,Integer> charCountMap = new HashMap<>();
        for(int i=0;i<s1.length();i++)
        {
            charCountMap.put(s1.charAt(i),charCountMap.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i=0;i<s2.length();i++) {
        if(charCountMap.containsKey(s2.charAt(i)) && charCountMap.get(s2.charAt(i)) > 0)
        {
            charCountMap.put(s2.charAt(i),charCountMap.get(s2.charAt(i))-1);
        }
        else
        {
            return false;
        }
        }
        return true;
    }
}
