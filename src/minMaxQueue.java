import java.util.*;

public class minMaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    boolean isMax;

    public minMaxQueue(boolean isMax) {
        this.queue = new LinkedList<>();
        this.deque = new LinkedList<>();
        this.isMax = isMax;
    }

    public void enqueue(int e) {
        queue.add(e);
        while (!deque.isEmpty()) {
            if (isMax ? deque.getLast() >= e : deque.getLast() <= e) {
                break;
            }
            deque.removeLast();
        }
        deque.addLast(e);
    }

    public int dequeue() {
        if (!queue.isEmpty()) {
            int result = queue.remove();
            if (result == deque.getFirst()) {
                deque.removeFirst();
            }
            return result;
        }
        throw new NoSuchElementException("Called dequeue() on empty queue!");
    }

    public int getMin() {
        if (isMax) {
            throw new NoSuchElementException("Called getMin() on max queue!");
        }
        if (!deque.isEmpty()) {
            return deque.getFirst();
        }
        throw new NoSuchElementException("Empty Queue");
    }

    public int getMax() {
        if (!isMax) {
            throw new NoSuchElementException("Called getMax() on min queue!");
        }
        if (!deque.isEmpty()) {
            return deque.getFirst();
        }
        throw new NoSuchElementException("Empty Queue");
    }

    public int size() {
        return queue.size();
    }
}
