/**
 * An implementation of a Minimum Priority Queue using a Binary Heap.
 *
 * Credit:
 * @author William Fiset
 * https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/datastructures/priorityqueue/BinaryHeap.java
 */
import java.util.*;

public class PriorityQueue<T extends Comparable<T>> {
    private List<T> heap;

    public PriorityQueue() {
        this.heap = new ArrayList<>();
    }

    public PriorityQueue(Collection<T> elements) {
        for (T element: elements) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public void clear() {
        heap.clear();
    }

    public int size() {
        return heap.size();
    }

    public void add(T element) {
        if (element == null) throw new IllegalArgumentException();
        heap.add(element);
        int lastIndex = size() - 1;
        swim(lastIndex);
    }

    public T poll() {
        if (isEmpty()) return null;
        return removeAt(0);
    }

    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    public boolean contains(T element) {
        for (int i = 0; i < size(); i++) {
            if (heap.get(i).equals(element)) return true;
        }
        return false;
    }

    public boolean remove(T element) {
        if (element == null) return false;
        for (int i = 0; i < size(); i++) {
            if (element.equals(heap.get(i))) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private void sink(int i) {
        while (true) {
            int left = 2 * i + 1, right = 2 * i + 2;
            int smallest = left;
            if (right < size() && less(right, left)) smallest = right;

            if (left >= size() || less(i, smallest)) break;
            swap(smallest, i);
            i = smallest;
        }
    }

    private void swim(int i) {
        int parent = (i - 1) / 2;
        while (i > 0 && less(i, parent)) {
            swap(parent, i);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private T removeAt(int index) {
        if (isEmpty()) return null;

        int lastIndex = size() - 1;
        T removed = heap.get(lastIndex);
        if (index == lastIndex) return removed;

        swap(lastIndex, index);
        heap.remove(lastIndex);

        T elem = heap.get(index);
        sink(index);

        if (heap.get(index).equals(elem)) swim(index);
        return removed;
    }

    private boolean less(int i, int j) {
        T node_i = heap.get(i), node_j = heap.get(j);
        return node_i.compareTo(node_j) <= 0;
    }

    private void swap(int i, int j) {
        T node_i = heap.get(i), node_j = heap.get(j);
        heap.set(i, node_j);
        heap.set(j, node_i);
    }
}
