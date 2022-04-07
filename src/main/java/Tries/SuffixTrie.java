package Tries;

public class SuffixTrie {
    // trie will start with root node
    Node root;

    public SuffixTrie() {
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

    public static void main(String[] args) {
        String word = "hello";
        SuffixTrie trie = new SuffixTrie();
        for(int i=0;i<word.length();i++) {
            trie.insert(word.substring(i));
        }
        System.out.println(trie.search("ello"));
    }
}
