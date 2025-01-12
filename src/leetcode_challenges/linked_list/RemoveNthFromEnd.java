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
        var fast = dummy;
        var slow = dummy;

        // move forward n times
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // move the slow pointer to the point where fast is null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // since fast is already n steps ahead, by the time fast is null
        // slow will be n-1steps behind, so the slow.next will be the nth node we need to skip

        slow.next = slow.next.next;

        return dummy.next;

    }

    public static void main(String[] args) {
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        // head = new ListNode(1);
        var removed = removeNthFromEndV2(head, 2);
        System.out.println(removed);
    }
}
