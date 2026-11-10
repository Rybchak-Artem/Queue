public class Queue {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class Queues {
        private Node head;
        private Node tail;
        private int size;

        public void enqueue(int value) {
            Node node = new Node(value);
            if (tail == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public int dequeue() {
            if (head == null) {
                throw new IllegalStateException("Stack empty");
            }
            int value = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return value;
        }

        public int peek() {
            if (head == null) {
                throw new IllegalStateException("Stack empty");
            }
            return head.data;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void clear() {
            head = null;
            tail = null;
            size = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Queue [head -> tail]: ");
            if (head == null) {
                return sb.append("Empty").toString();
            }
            Node current = head;
            while (current != null) {
                sb.append(current.data);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Queues queue = new Queues();

        queue.enqueue(12);
        queue.enqueue(25);
        queue.enqueue(8);
        System.out.println(queue);
        System.out.println("Size: " + queue.size());
        System.out.println("First element: " + queue.peek());

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println(queue);

        queue.enqueue(40);
        System.out.println("Enqueue 40: ");
        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.println("dequeue: " + queue.dequeue() + ", left: " + queue.size());
        }
        System.out.println(queue);

        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
