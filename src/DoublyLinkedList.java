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
        return node;
    }

    /**
     * Advanced print function
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLLNode ptr = head;
        while (ptr != null) {
            sb.append((ptr.prev == null ? "n <- [" : "[") + ptr.val + (ptr.next == null ? "] -> n" : "] <-> "));
            ptr = ptr.next;
        }
        return sb.toString();
    }
}
