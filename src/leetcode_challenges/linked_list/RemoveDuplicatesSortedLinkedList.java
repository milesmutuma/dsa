package leetcode_challenges.linked_list;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 */
public class RemoveDuplicatesSortedLinkedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode current = head;
        ListNode prev = dummy;
        while (current != null) {
            // check the nodes neighbors

            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            // If prev.next is current, no duplicates were found
            if (prev.next == current) {
                prev = prev.next;
            } else {
                // Skip all duplicates
                prev.next = current.next;
            }

            // Move to the next node
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // test
        // head = [1,2,3,3,4,4,5]
        // Output: [1,2,5]
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode result = deleteDuplicates(head);
        System.out.println(result);
    }
}
