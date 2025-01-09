package leetcode_challenges.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        var current = head;
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int count = 0;

        while (current != null) {
            nodeMap.put(count, current);
            current = current.next;
            count++;
        }

        ListNode dummy = new ListNode(0);
        var start = dummy;
        for (var entry : nodeMap.entrySet()) {
            if (entry.getKey() != (nodeMap.size() - n)) {
                var value = entry.getValue();
                value.next = null;
                dummy.next = entry.getValue();
                dummy = dummy.next;
            }
        }

        return start.next;

    }

    public static ListNode removeNthFromEndV2(ListNode head, int n) {
        var dummy = new ListNode(0);
        dummy.next = head;
        var first = dummy;
        var second = dummy;

        // Move the second pointer n steps ahead
        for (int i = 1; i <= n + 1; i++) {
            second = second.next;
        }

        // Move both pointers until second reaches the end
        while (second != null) {
            first = first.next;
            second = second.next;
        }

        // Skip the nth node
        first.next = first.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        // head = new ListNode(1);
        var removed = removeNthFromEndV2(head, 2);
        System.out.println(removed);
    }
}
