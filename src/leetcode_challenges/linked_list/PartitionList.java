package leetcode_challenges.linked_list;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 */
public class PartitionList {


    public static ListNode partition(ListNode head, int x) {

        ListNode lessThan = new ListNode(-4);
        ListNode lessThanHead = lessThan;
        ListNode greaterThan = new ListNode(-2);
        ListNode startHead = greaterThan;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                lessThan.next = current;
                lessThan = lessThan.next;
            }else {
                greaterThan.next = current;
                greaterThan = greaterThan.next;
            }
            current = current.next;
        }

        greaterThan.next = null;
        lessThan.next = startHead.next;
        return lessThanHead.next;
    }

    public static void main(String[] args) {
        // test

        // head = [1,4,3,2,5,2], x = 3
        // Output: [1,2,2,4,3,5]

        var head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        var result = partition(head, 3);

        System.out.println(result);
    }
}
