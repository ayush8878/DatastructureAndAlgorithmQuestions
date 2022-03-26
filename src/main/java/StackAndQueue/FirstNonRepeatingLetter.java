package StackAndQueue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingLetter {
    public static void main(String[] args) {
        String input = "aabccbcd";
        printFirstNonRepeatingLetter(input);
    }

    private static void printFirstNonRepeatingLetter(String input) {
        Map<Character,Integer> map = new HashMap<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(int i=0;i<input.length();i++)
        {
            char ch = input.charAt(i);
            // update char count in map
            map.put(ch,map.getOrDefault(ch,0)+1);
            // check if map has unique char
            if(map.get(ch)==1)
            {
                queue.push(ch);
            }

                printLetter(queue,map);
        }
    }

    private static void printLetter(ArrayDeque<Character> queue, Map<Character, Integer> map) {
        while(!queue.isEmpty())
        {
            char c = queue.peek();
            // remove top if count is more
            if (map.get(c) > 1)
            {
                queue.pop();
            }
            else
            {
                break;
            }
        }
        // print the data
        if(queue.isEmpty())
        {
            System.out.print("-1");
        }
        else {
            System.out.print(queue.peekLast());
        }
    }
}
