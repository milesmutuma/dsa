package leetcode_challenges.linked_list;

import java.util.Stack;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseLinkedListKthGroup {
    record CanReverse(boolean canRevers, ListNode node) {
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // check if we can reverse
        var newHead = head;

        if (!canReverse(newHead, k)) return head;

        var dummy = new ListNode(0);
        newHead = dummy;
        boolean canReverse = true;
        while (canReverse) {
            dummy.next = reverseList(head, k);
            while (dummy.next != null) {
                dummy = dummy.next;
                head = head.next;
            }
            canReverse = canReverse(head, k);
        }

        dummy.next = head;

        return newHead.next;
    }

    private static ListNode reverseList(ListNode head, int k) {
        Stack<Integer> stack = new Stack<>();

        var current = head;
        int count = 0;
        while (count < k) {
            stack.add(current.val);
            current = current.next;
            count++;
        }

        var dummy = new ListNode(0);
        current = dummy;
        while (!stack.isEmpty()) {
            current.next = new ListNode(stack.pop());
            current = current.next;
        }

        return dummy.next;
    }

    private static boolean canReverse(ListNode head, int k) {
        int count = 0;
        var current = head;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        return count == k;
    }

    public static ListNode reverseKGroupV2(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode end = head;

        int count = 0;
        while (end != null) {
            count++;
            if (count % k == 0) {
                start = reverse(start, end.next);
                end = start.next;
            } else {
                end = end.next;
            }
        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode current = start.next;
        ListNode prev = start;
        ListNode first = current;

        while (current != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        start.next = prev;
        first.next = current;

        return first;
    }

    public static void main(String[] args) {
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        var reversed = reverseKGroupV2(head, 2);

        System.out.println(reversed);
    }
}
