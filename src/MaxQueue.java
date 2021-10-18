import java.util.*;

public class MaxQueue<T extends Comparable<T>> {
    private final Queue<T> queue;
    private final Deque<T> maxDeque;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.maxDeque = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();;
        maxDeque.clear();
    }

    public int size() {
        return queue.size();
    }

    public void enqueue(T e) {
        queue.add(e);
        while (!maxDeque.isEmpty()) {
            if (maxDeque.getLast().compareTo(e) >= 0) {
                break;
            }
            maxDeque.removeLast();
        }
        maxDeque.addLast(e);
    }

    public T dequeue() {
        if (!queue.isEmpty()) {
            T result = queue.remove();
            if (result == maxDeque.getFirst()) {
                maxDeque.removeFirst();
            }
            return result;
        }
        throw new NoSuchElementException("Called dequeue() on empty queue!");
    }

    public T peek() {
        return queue.peek();
    }

    public boolean contains(T element) {
        return queue.contains(element);
    }

    public T getMax() {
        if (!minDeque.isEmpty()) {
            return minDeque.getFirst();
        }
        throw new NoSuchElementException("Empty Queue");
    }
}
