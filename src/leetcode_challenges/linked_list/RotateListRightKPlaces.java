package leetcode_challenges.linked_list;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */
public class RotateListRightKPlaces {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        Deque<ListNode> deque = new ArrayDeque<>();

        ListNode current = head;

        while (current != null) {
            deque.offerLast(current);
            current = current.next;
        }

        while (k > 0) {
            k--;
            var currentLast = deque.pollLast();
            deque.offerFirst(currentLast);
        }

        ListNode dummy = new ListNode(0);
        var newHead = dummy;
        while (!deque.isEmpty()) {
            dummy.next = deque.pollFirst();
            dummy = dummy.next;
            dummy.next = null;
        }

        return newHead.next;
    }

    /**
     * The calculation int stepsToNewHead = length - k; determines the number of steps needed to find the new head of the linked list after rotating it to the right by
     * 𝑘
     * k places. Here's why this calculation is necessary and how it works:
     * <p>
     * Reason for length - k
     * When you rotate a linked list to the right by
     * 𝑘
     * k places, the last
     * 𝑘
     * k nodes of the list will become the first
     * 𝑘
     * k nodes in the rotated list. This means the new head will be at position
     * length
     * −
     * 𝑘
     * length−k in the original list (1-based index).
     * <p>
     * The steps to reach this new head are exactly
     * length
     * −
     * 𝑘
     * length−k from the start of the list.
     * <p>
     * Breaking It Down
     * Given:
     * List length
     * =
     * length
     * List length=length
     * 𝑘
     * =
     * 𝑘
     * %
     * length
     * k=k%length (to ensure
     * 𝑘
     * k is within bounds)
     * New head position
     * =
     * length
     * −
     * 𝑘
     * New head position=length−k
     * The last
     * 𝑘
     * k nodes of the list need to move to the front.
     * The remaining
     * length
     * −
     * 𝑘
     * length−k nodes will shift to the back.
     * Visual Example:
     * List: 1 -> 2 -> 3 -> 4 -> 5
     * Length:
     * 5
     * 5
     * Rotations (
     * 𝑘
     * k):
     * 2
     * 2
     * <p>
     * After
     * 𝑘
     * =
     * 2
     * k=2 rotations, the result should be:
     * 4 -> 5 -> 1 -> 2 -> 3
     * <p>
     * To identify the new head (4 in this case):
     * <p>
     * The new head is at position
     * length
     * −
     * 𝑘
     * =
     * 5
     * −
     * 2
     * =
     * 3
     * length−k=5−2=3 (1-based index).
     * Start from the current head (1), and move
     * 3
     * 3 steps to reach 4.
     * stepsToNewHead
     * stepsToNewHead tells us how many steps to take to identify the new head of the list.
     * <p>
     * Why Is This Needed?
     * To perform the rotation, you need to:
     * <p>
     * Find the new head of the list.
     * Update the last node to point to null to break the circular dependency after shifting nodes.
     * stepsToNewHead = length - k provides the exact number of steps to locate the new head without iterating through the entire list unnecessarily.
     * <p>
     * Another Example
     * Input:
     * List: A -> B -> C -> D
     * Length:
     * 4
     * 4
     * Rotations:
     * 𝑘
     * =
     * 1
     * k=1
     * <p>
     * 𝑘
     * =
     * 𝑘
     * %
     * length
     * =
     * 1
     * k=k%length=1.
     * stepsToNewHead
     * =
     * length
     * −
     * 𝑘
     * =
     * 4
     * −
     * 1
     * =
     * 3
     * stepsToNewHead=length−k=4−1=3.
     * Start at A and move
     * 3
     * 3 steps:
     * Step 1: B
     * Step 2: C
     * Step 3: D → New Head.
     * Output: D -> A -> B -> C
     * <p>
     * Conclusion
     * The calculation stepsToNewHead = length - k pinpoints the position of the new head after rotation. It works efficiently by leveraging the properties of rotation and avoids redundant iterations, ensuring the rotation logic aligns with the desired outcome.
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRightV2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Find the length of the list and the last node
        var current = head;
        int length = 0;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connect the last node to the head to form a circle
        current.next = head;

        // Calculate the effective rotations needed
        k = k % length;
        int newStepsAhead = length - k;

        // Find the new head and the node before it
        ListNode newTail = current;
        while (newStepsAhead > 0) {
            newTail = newTail.next;
            newStepsAhead--;
        }

        ListNode newHead = newTail.next;
        // Break the circle
        newTail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        // test
        // Input: head = [1,2,3,4,5], k = 2
        // Output: [4,5,1,2,3]
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        // [0,1,2]
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode result = rotateRightV2(head, 4);
        System.out.println(result.val); // 4
    }


}
