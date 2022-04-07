package Tries;

public class CuteLittleCat {

    public static void main(String[] args) {
        String document = "little cute cat loves to code in c++, java & python";
        String words[] = {"cute cat","ttle","cat","quick","big"};
        Trie trie = new Trie();
        trie.documentSearch(document,words);
    }
}
