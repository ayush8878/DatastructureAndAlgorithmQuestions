package String;

import java.util.*;
import java.util.stream.Collectors;

public class StringKeySort {
    public static void main(String[] args) {
        /*Scanner s = new Scanner(System.in);
        System.out.println("Enter total strings");
        int inputCount = s.nextInt();
        List<String> strings = new ArrayList<>();
        for(int i = 0; i< inputCount;i++)
        {
            System.out.println("Enter string "+(i+1)+":");
            strings.add(s.nextLine());
        }
        System.out.println("Enter column, reverse and comparison type");
        String inputConstrains = s.nextLine();*/
        List<String> strings = new ArrayList<>();
        strings.add("92 022");
        strings.add("82 12");
        strings.add("77 13");
        String inputConstrains = "2 false other";
        String[] constrains = inputConstrains.split(" ");
        int column = Integer.parseInt(constrains[0]) - 1;
        boolean isReversed = Boolean.parseBoolean(constrains[1]);
        boolean isNumeric = "numeric".equalsIgnoreCase(constrains[2]) ? true : false;
        Collection<String> sortedString = performStringSort(strings, column, isReversed, isNumeric);
        System.out.println(sortedString);
    }

    private static Collection<String> performStringSort(List<String> strings, int column, boolean isReversed, boolean isNumeric) {
        Comparator<String> numeric = Comparator.comparingInt(Integer::parseInt);
        Comparator<String> lexo = (Comparator.naturalOrder());
        if (isReversed) {
            numeric.reversed();
            lexo.reversed();
        }
        TreeMap<String, String> columnKeyMap = new TreeMap<String, String>(isNumeric ? numeric : lexo);
        // populate map
        for (String str :
                strings) {
            columnKeyMap.put(str.split(" ")[column], str);
        }
        if (isReversed) {
            return columnKeyMap.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
        return columnKeyMap.values();
    }
}
