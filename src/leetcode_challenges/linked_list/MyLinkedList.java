package leetcode_challenges.linked_list;


public class MyLinkedList {



    private Node<Character> head;
    private int size = 0;

    public Node<Character> getHead() {
        return head;
    }

    public void insertAtTheEnd(char data) {
        var node = new Node<Character>(data);

        if (head == null) {
            head = node;
        } else {
            Node<Character> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public void insertAtTheStart(char data) {
        var node = new Node<Character>(data);

        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void displayLinkedList() {
        if (head == null) {
            System.out.println("Empty Linked List");
        }
        var current = head;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayRecursevly(Node head) {
        if (head == null)
            return;

        System.out.print(head.data + "->");
        displayRecursevly(head.next);
    }

    public char[] getValues() {
        if (head == null)
            return new char[]{};

        char[] values = new char[size];

        var current = head;
        int count = 0;
        while (current != null) {
            values[count++] = current.data;
            current = current.next;
        }

        return values;
    }

    public char[] getValuesRecursion() {
        if (head == null)
            return new char[]{};

        char[] values = new char[size];

        fillValues(head, values, 0);

        return values;
    }

    private void fillValues(Node<Character> head, char[] values, int index) {
        if (head == null) return;

        values[index] = head.data;
        fillValues(head.next, values, index + 1);
    }

    public int getSumRecursion() {
        if (head == null) return 0;

        return sum(head);
    }

    private int sum(Node<Character> head) {
        if (head == null) return 0;

        return (head.data - '0') + sum(head.next);
    }

    public boolean itemExists(char item) {
        if (size == 0) return false;

        var current = head;
        while (current != null) {
            if (current.data == item)
                return true;

            current = current.next;
        }

        return false;
    }

    public boolean itemExistsRecursion(char item) {
        return searchItem(head, item);
    }

    private boolean searchItem(Node<Character> head, char item) {
        if (head == null) return false;

        if (head.data == item) return true;

        return searchItem(head.next, item);
    }

    public char getNodeByIndex(int index) {
        if (size == 0) return '-'; // represents null

        var current = head;

        int count = 0;
        while (current != null) {
            if (count == index) return current.data;
            count++;
            current = current.next;
        }

        return '-';
    }

    public char getNodeByIndexRecursion(int index) {
        if (size == 0) return '-'; // represents null

        return searchIndex(head, index);
    }

    private char searchIndex(Node<Character> head, int index) {
        if (head == null) return '-';

        if (index == 0) return head.data;

        return searchIndex(head.next, index - 1);
    }

    public MyLinkedList reverseList() {
        Node<Character> node = reverseList(head, null);

        var linkedList = new MyLinkedList();

        var current = node;
        while (current != null) {
            linkedList.insertAtTheEnd(current.data);
            current = current.next;
        }

        return linkedList;
    }

    private Node reverseList(Node<Character> head) {
        if (head == null || head.next == null) return head;

        var current = head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }


        return prev;

    }

    private Node<Character> reverseList(Node<Character> head, Node<Character> prev) {
        if (head == null) {
            return prev;
        }

        Node<Character> next = head.next;
        head.next = prev;
        return reverseList(next, head);
    }


    @Override
    public String toString() {
        displayLinkedList();
        return "";
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.insertAtTheEnd('1');
        linkedList.insertAtTheEnd('2');
        linkedList.insertAtTheEnd('3');
        linkedList.insertAtTheEnd('4');

        linkedList.reverseList().toString();
    }
}
