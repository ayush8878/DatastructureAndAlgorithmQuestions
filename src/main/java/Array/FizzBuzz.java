package Array;

import java.util.*;
public class FizzBuzz
{
    public static void main(String args[])
    {
        List<String> result = fizzbuzz(10);
        System.out.print(result);
    }

    public static List<String> fizzbuzz(int n)
    {
        List<String> result = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            }
        }
        return result;
    }
}