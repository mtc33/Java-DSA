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
