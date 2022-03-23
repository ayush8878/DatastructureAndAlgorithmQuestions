package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SubSequenceSort {

    public static void main(String[] args) {
        String str = "abcd";
        List<String> subsequences = new ArrayList<>();
        getSubSequence("",str,subsequences);
        Comparator<String> comparator = (s1, s2) -> (s2.length() == s1.length())?s1.compareTo(s2):s1.length() - s2.length();
        subsequences.sort(comparator);
        System.out.println(subsequences);
    }

    public static void getSubSequence(String prefix,String str,List<String> subsequences)
    {
        // base case
        if(str == null || str.isEmpty())
        {
            return;
        }
        // extract first charter of str
        char ch = str.charAt(0);
        // substring after removing first char
        String subStr = str.substring(1);
        // including the character
        getSubSequence(prefix+ch,subStr,subsequences);
        // not including the character
        getSubSequence(prefix,subStr,subsequences);
        // storing subseq
        subsequences.add(prefix+ch);
    }
}
