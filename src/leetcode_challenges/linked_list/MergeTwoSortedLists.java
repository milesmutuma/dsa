package leetcode_challenges.linked_list;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        if (list1 == null) return list2;
        if (list2 == null) return list1;


        var current = list1;

        if (list2.val < list1.val) {
            current = list2;
        }
        var tail = current;

        var head1 = list1;
        var head2 = list2;

        if (list2.val < list1.val) {
            head2 = list2.next;
        } else {
            head1 = list1.next;
        }

        while (head1 != null && head2 != null) {

            if (head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;

            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }

        return tail;
    }

    public static void main(String[] args) {
        // test mergeTwoLists

        // list1 = [1,2,4], list2 = [1,3,4]
        // Output: [1,1,2,3,4,4]

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = mergeTwoLists(list1, list2);

        // loop through the list
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        // Input: list1 = [], list2 = []
        //Output: []
        ListNode list3 = null;
        ListNode list4 = null;

        ListNode result2 = mergeTwoLists(list3, list4);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }
    }
}


