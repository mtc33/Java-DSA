/**
 * An implementation of a Least Recently Used (LRU) Cache with a specified capacity.
 * When the cache is about to go over capacity, it evicts the least recently used item.
 * The cache supports get and put operations.
 *
 * The get operation gets the value of the key if the key exists in the cache.
 * The put operation sets or inserts the value of the key if it is not already present.
 */
import java.util.*;

public class LRUCache {
    Map<Integer, DLLNode> map;
    DoublyLinkedList dll;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DLLNode target = map.get(key);
        dll.add(dll.remove(target));
        return target.getVal();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLLNode target = map.get(key);
            target.setVal(value);
            dll.add(dll.remove(target));
        }
        else {
            DLLNode newNode = new DLLNode(key, value);
            map.put(key, newNode);
            dll.add(newNode);
            if (capacity == 0) {
                map.remove(dll.head.key);
                dll.remove(dll.head);
            }
            else {
                capacity--;
            }
        }
    }
}
