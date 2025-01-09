package leetcode_challenges.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class CheckCyclic {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        var current = head;

        Set<ListNode> visited = new HashSet<>();
        while (current != null) {
            if (visited.contains(current)) return true;
            visited.add(current);
            current = current.next;
        }

        return false;
    }

    public boolean hasCycleV2(ListNode head) {
        if (head == null || head.next == null) return false;

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps

            // If slow and fast meet, a cycle is detected
            if (slow == fast) return true;
        }

        return false;
    }


}
