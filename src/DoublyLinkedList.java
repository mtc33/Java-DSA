/**
 * An implementation of a Doubly Linked List.
 * Each node in the list has pointers to both the next and previous nodes.
 *
 * @author Mark Chen, chenmark33@gmail.com
 */

public class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(DLLNode newNode) {
        if (head == null) {
            this.head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        this.tail = newNode;
        size++;
    }

    public DLLNode remove(DLLNode node) {
        DLLNode removed = node;
        if (node == head) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            }
            else {
                head = null;
            }
        }
        else if (node == tail) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                tail = null;
            }
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return removed;
    }

    @Override
    public String toString() {
        DLLNode ptr = head;
        while (ptr != null) {
            System.out.print("[" + ptr.val + "] -> ");
            ptr = ptr.next;
        }
        return "";
    }
}
