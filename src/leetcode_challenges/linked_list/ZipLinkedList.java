package leetcode_challenges.linked_list;

/**
 * merge two linkedlist in the format of
 * linked1 = a --> b -> c -> d
 * linked2 = f -> g -> h
 * output -> a -> f -> b -> g -> c -> h -> d
 */
public class ZipLinkedList {



    private static Node<Character> zip(Node<Character> head1, Node<Character> head2) {
        var tail = head1;
        var current1 = head1.next;
        var current2 = head2;

        var addFirst = false;
        while (current1 != null && current2 != null) {
            if (!addFirst) {
                tail.next = current2;
                tail = tail.next;
                current2 = current2.next;
            } else {
                tail.next = current1;
                tail = tail.next;
                current1 = current1.next;
            }

            addFirst = !addFirst;
        }

        if (current1 != null) {
            tail.next = current1;
        }
        if (current2 != null) {
            tail.next = current2;
        }

        return head1;

    }

    public static void main(String[] args) {
        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.insertAtTheStart('a');
        linkedList1.insertAtTheEnd('b');
        linkedList1.insertAtTheEnd('c');
        linkedList1.insertAtTheEnd('d');

        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.insertAtTheStart('f');
        linkedList2.insertAtTheEnd('g');
        linkedList2.insertAtTheEnd('h');

        Node<Character> head = zip(linkedList1.getHead(), linkedList2.getHead());

        linkedList1.displayRecursevly(head);
    }
}
