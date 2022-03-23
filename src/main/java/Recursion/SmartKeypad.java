package Recursion;

public class SmartKeypad {
    static String[] keypad = new String[]{"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
    public static void main(String[] args) {
     generateKeypadCombinations("23","",0);

     // issue with this case
     generateKeypadCombinations("203","",0);
    }

    public static void generateKeypadCombinations(String n,String output,int i)
    {
        // base case
        if(n.length() == i)
        {
            System.out.println(output);
            return;
        }
        int position = Character.getNumericValue(n.charAt(0));
        // handle 0 and 1 keypad number and skip
        if(position == 0 || position == 1)
        {
            generateKeypadCombinations(n,output,i+1);
        }
        String value = keypad[position];
        // iteratively generate combinations
        for(int k = 0;k<value.length();k++)
        {
            generateKeypadCombinations(n,output+value.charAt(k),i+1);
        }

    }
}
