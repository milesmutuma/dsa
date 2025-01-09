package leetcode_challenges.linked_list;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedListV2 {

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        var current = head;
        int count = 1;

        if (current == null || current.next == null) return head;

        if (right == left) return head; // means we are reversing one number

        // we need to move the pointer to the left
        while (current != null && count < left - 1) {
            count++;
            current = current.next;
        }

        var start = current;
        current = current.next;
        var last = current; // once reversal happens, current will move to the back

        ListNode prev = null;
        count++;
        while (current != null && count <= right) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        start.next = prev;
        last.next = current;


        return head;
    }

    private static ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode dummy = new ListNode(0); // Dummy node to simplify edge cases
        dummy.next = head;

        ListNode current = dummy; // Start from the dummy node
        int count = 0;

        // Step 1: Move `current` to the node before `left`
        while (count < left - 1) {
            current = current.next;
            count++;
        }

        ListNode start = current; // `start` is the node before `left`
        current = current.next;   // Move to the node at `left`
        ListNode last = current;  // `last` will eventually become the tail of the reversed sublist

        // Step 2: Reverse the sublist
        ListNode prev = null;
        while (count < right) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Step 3: Reconnect the reversed sublist
        start.next = prev; // Connect the node before `left` to the new head of the reversed sublist
        last.next = current; // Connect the tail of the reversed sublist to the remaining list

        return dummy.next; // Return the new head (skip dummy)
    }

    public static void main(String[] args) {
        var head = new ListNode(3, new ListNode(5));
        head = reverseBetween2(head, 1, 2);
        System.out.println(head);
    }
}
