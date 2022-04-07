package LRUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Node
{
 String key;
 int value;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache
{
    int MAX_SIZE;
    LinkedList<Node> l;
    Map<String,Node> m;

    public LRUCache(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE > 1 ?MAX_SIZE:1;
        m = new HashMap<String, Node>(this.MAX_SIZE);
        l = new LinkedList<Node>();

    }
    public void insertKeyValue(String key,int value)
    {
        // if in case value already present in cache
        if(m.containsKey(key))
        {
            Node node = m.get(key);
            node.value = value;
        }
        else
        {
            // check if cache is full or not
            // remove least recently used item from cache
            if(l.size() == MAX_SIZE)
            {
                Node last = l.removeLast();
                m.remove(last.key);
            }

            // insert new node at start
            Node n = new Node(key,value);
            l.addFirst(n);
            m.put(key,n);
        }

    }

    public Node getValue(String key)
    {
        if(m.containsKey(key))
        {
            // push node at top of list
            Node n = m.get(key);
            l.remove(n);
            l.addFirst(n);
            return n;
        }
        return null;
    }

    public String mostRecentKey()
    {
        return l.getFirst().key;
    }
}
public class LRUCacheImpl {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.insertKeyValue("mango",10);
        cache.insertKeyValue("apple",10);
        cache.insertKeyValue("guava",10);
        System.out.println(cache.mostRecentKey());

        cache.insertKeyValue("mango",40);
        System.out.println(cache.mostRecentKey());

        System.out.println(cache.getValue("mango").value);

        cache.insertKeyValue("banana",20);

        if(cache.getValue("apple") == null)
        {
            System.out.println("apple does not exists");
        }

        if(cache.getValue("guava") == null)
        {
            System.out.println("guava does not exists");
        }

        if(cache.getValue("banana") == null)
        {
            System.out.println("banana does not exists");
        }

        if(cache.getValue("mango") == null)
        {
            System.out.println("mango does not exists");
        }
    }
}
