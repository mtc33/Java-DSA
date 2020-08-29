public class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
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
    }

    public DLLNode remove(DLLNode node) {
        DLLNode removed = node;
        if (node == head) {
            head = head.next;
        }
        else if (node == tail) {
            tail = tail.prev;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return removed;
    }
}
