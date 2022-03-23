package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringTokenizer {
    public static void main(String[] args) {
        // String str = "Hello__this__is__Ayush, we are now learning coding with Ayush__a__";
        // String str = "Hello__";
        String str = "__Hello__HELLO__HELLO__";
        String delimiter = "__";
        System.out.println(tokenizeString(str,delimiter));
    }

    /**
     * This method will tokenize sting based on delimiter
     * @param input
     * @param delimiter
     * @return
     */
    private static List<String> tokenizeString(String input, String delimiter)
    {
        List<String> tokens = new ArrayList<>();
        if(input.length() < delimiter.length())
        {
            return Collections.emptyList();
        }
        // use i for iteration and curr for the current token to track current position of token
        int i = 0,currToken = 0;
        while (i< input.length())
        {
            boolean found = true;
            // look for delimiter in string
            for(int j=0;j<delimiter.length();j++)
            {
                if(!(input.charAt(i+j) == delimiter.charAt(j)))
                {
                    found = false;
                }
            }
            // if found then add to tokens
            if (found)
            {
                // handle edge case where string begins with delimiter
                if(i>0) {
                    tokens.add(input.substring(currToken, i));
                }
                // skip found delimiter
                currToken=i=i+delimiter.length();
            }
            else
            {
                i++;
            }
        }
        // add token after last delimiter found
        if(currToken<input.length())
        tokens.add(input.substring(currToken));
        return tokens;
    }
}
