package Recursion;

import java.util.ArrayList;
import java.util.List;

/* Issue with duplicates */
public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        generatePermutations(str,0,str.length()-1);
    }

    private static void generatePermutations(String str,int left,int right) {
        if(left == str.length())
        {
            System.out.println(str);
            return;
        }
        for(int k=0;k<right;k++)
        {
            str = swap(str,left,k);
            generatePermutations(str,left+1,right);
            str = swap(str,k,right);
        }
    }

    static String swap(String str,int x,int y)
    {
        StringBuilder sb = new StringBuilder(str);
        char tmp = str.charAt(x);
        sb.setCharAt(x,str.charAt(y));
        sb.setCharAt(y,tmp);
        return sb.toString();
    }
}
