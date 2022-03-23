package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBrackets {
    public static void main(String[] args) {
        String output = "";
        generateBrackets(output,2,0,0,0);
    }
    private static void generateBrackets(String output, int n, int open, int close,int i) {
        //base case
        if(i == 2*n)
        {
           System.out.println(output);
           return;
        }

        // opening
        if(open< n)
        generateBrackets(output+"(",n,open+1,close,i+1);

        // closing
        if(close < open)
        generateBrackets(output+")",n,open,close+1,i+1);
    }
}
