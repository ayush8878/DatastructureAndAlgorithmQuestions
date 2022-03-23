package String;

public class SearchInString {
    public static void main(String[] args) {
        String str = "this is a game and another game and then after its game again";
        String search = "game";
        int index = 0;
        int count = 0;
        while (index < str.length())
        {
            index = str.indexOf(search,index);
            if(index == -1)
                break;
            index+=search.length();
            count++;
        }
        System.out.println("Occurrence of : "+search+" in string: "+str+" is "+count);
    }
}
