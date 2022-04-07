package Tries;

import java.util.HashMap;
import java.util.Map;

class Node
{
    // data will hold the character
    public char data;
    // m will hold the associated char nodes
    public Map<Character,Node> m;
    // isTerminal represents terminating char
    public boolean isTerminal;

    public Node(char data) {
        this.data = data;
        m = new HashMap<>();
    }
}
public class Trie {
    // trie will start with root node
    Node root;

    public Trie() {
        // root will be a space char
        root = new Node('\0');
    }

    /**
     * This method will insert word in trie
     * @param word
     */
    void insert(String word)
    {
        // initialize temp with root
        Node temp = root;
        // for each character in word
        for(char ch:word.toCharArray())
        {
            // if character is not present then add in trie otherwise move to next char
            if(!temp.m.containsKey(ch))
            {
                // create a new node
                Node node = new Node(ch);
                // insert in map
                temp.m.put(ch, node);
            }
            // move to next char
            temp = temp.m.get(ch);
        }
        // at the end char mark as terminal
        temp.isTerminal = true;
    }

    /**
     * This method will search word in trie
     * @param word
     * @return
     */
    boolean search(String word)
    {
        // start with root
        Node temp = root;
        // for each word
        for(char ch:word.toCharArray())
        {
            // check if  key is present in map if not return false
            if(!temp.m.containsKey(ch))
            {
                return false;
            }
            // move the temp forward
            temp = temp.m.get(ch);
        }
        // check if the last char is terminating
        return temp.isTerminal;
    }

    /**
     * This method will help in document searching using trie and maintains a memory for keeping data in it
     * @param document
     * @param i
     * @param memory
     */
    void searchHelper(String document,int i,Map<String,Boolean> memory)
    {
        // start with the root node
        Node temp = root;
        // for each word starting with index i check if there is any word in trie
        for (int j = i; j < document.length(); j++) {
            // get the char it j index
            char ch = document.charAt(j);
            // skip search if ch is not present in trie
            if(!temp.m.containsKey(ch))
            {
                return;
            }
            // move to next index
            temp = temp.m.get(ch);
            // if temp is a terminal node
            if(temp.isTerminal)
            {
                // fetch the string that is terminating
                String out = document.substring(i,i+(j-i+1));
                // keep in memory
                memory.put(out,true);
            }
        }
    }

    /**
     * This method will perform search on document and check if words are present in doc or not
     * @param document
     * @param words
     */
    public void documentSearch(String document,String [] words)
    {
        // Create Trie of words
        for(String word:words)
        {
            insert(word);
        }

        // create a memory which will keep the details about the word and if its present
        Map<String,Boolean> memory = new HashMap<>();

        // search on document by iterating over char by char
        for (int i = 0; i < document.length(); i++) {
            searchHelper(document,i,memory);
        }

        // printing press

        for(String word:words)
        {
            if(memory.containsKey(word) && memory.get(word) == true)
            {
                System.out.println(word +":Yes");
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"apple","ape","no","news","not","never"};
        Trie trie = new Trie();
        for(String word:words)
        {
            trie.insert(word);
        }
        System.out.println(trie.search("no"));
    }
}
