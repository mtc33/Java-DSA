/**
 * An implementation of a queue with both max and min APIs.
 * This queue supports enqueue, dequeue, min, and max operations.
 *
 * The min operation returns the minimum element currently stored in the queue.
 * The max operation returns the maximum element currently stored in the queue.
 *
 * @author Mark Chen, chenmark33@gmail.com
 */
import java.util.*;

public class MinMaxQueue<T extends Comparable<T>> {
    private Queue<T> queue;
    private Deque<T> minDeque;
    private Deque<T> maxDeque;

    public MinMaxQueue() {
        this.queue = new LinkedList<>();
        this.minDeque = new LinkedList<>();
        this.maxDeque = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();;
        minDeque.clear();
        maxDeque.clear();
    }

    public int size() {
        return queue.size();
    }

    public void enqueue(T e) {
        queue.add(e);
        while (!minDeque.isEmpty()) {
            if (minDeque.getLast().compareTo(e) <= 0) {
                break;
            }
            minDeque.removeLast();
        }
        while (!maxDeque.isEmpty()) {
            if (maxDeque.getLast().compareTo(e) >= 0) {
                break;
            }
            maxDeque.removeLast();
        }
        minDeque.addLast(e);
        maxDeque.addLast(e);
    }

    public T dequeue() {
        if (!queue.isEmpty()) {
            T result = queue.remove();
            if (result == minDeque.getFirst()) {
                minDeque.removeFirst();
            }
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

    public T getMin() {
        if (!minDeque.isEmpty()) {
            return minDeque.getFirst();
        }
        throw new NoSuchElementException("Empty Queue");
    }

    public T getMax() {
        if (!minDeque.isEmpty()) {
            return minDeque.getFirst();
        }
        throw new NoSuchElementException("Empty Queue");
    }
}
