package Hashing;

import java.util.*;
// issue with hashcode and equals needs to be fixed
class IntegerComparator implements Comparator<int[]>
{

    @Override
    public int compare(int[] o1, int[] o2) {
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<o1.length;i++)
        {
            count1 += i*o1[i];
            count2 += i*o2[i];
        }
        if(count1 == count2)
            return 0;
        if(count1 > count2)
            return 1;
        return -1;
    }
}
public class AnagramSubstring
{
    public static void main(String[] args)
    {
        String str = "abba";

        int count = findAllAnagramSubstring(str);
        System.out.print("Total Anagram Strings are: "+count);
    }

    public static int findAllAnagramSubstring(String str)
    {
        // Generate Substrings of str
        List<String> substrings = new ArrayList<>();
        for(int len = 1; len <=str.length();len++)
        {
            int start = 0;
            while(start+len <= str.length())
            {
                // Add string to list
                substrings.add(str.substring(start,start+len));
                start++;
            }
        }
        //  Update Map with all substrings count
        Map<Integer,Integer>  freqMap = new HashMap<>();
        Map<String,int[]>  subStrMap = new HashMap<>();
        for(String s:substrings)
        {
            int[] freq = new int[26];
            // update frequency of char
            for(char ch:s.toCharArray())
            {
                freq[ch - 'a'] = 1;
            }
            // update substring Map with the freq key
            subStrMap.put(s,freq);
            // update frequency in map by updating count to +1
            freqMap.put(Arrays.hashCode(freq),freqMap.getOrDefault(freq,0)+1);
        }


        // for each substring check in map if there are valid combinations for anagram and update count
        int count = 0;
        for(Map.Entry<String,int[]> entry:subStrMap.entrySet())
        {
            int[] freq = entry.getValue();
            int freqCount = freqMap.get(Arrays.hashCode(freq));
            if(freqCount > 1)
                count+=freqCount;
        }
        return count;
    }
}


