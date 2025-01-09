package leetcode_challenges.linked_list;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * i.e Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

        }

       return dummyHead.next;
    }

    private static Integer getValues(ListNode listNode) {
        StringBuilder builder = new StringBuilder();
        var current = listNode;
        while (current != null) {
            builder.append(current.val);
            current = current.next;
        }
        return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args) {
        // test addTwoNumbers

        // l1 = [2,4,3], l2 = [5,6,4]
        // Output: [7,0,8]

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val); // 7

        // test addTwoNumbers
        //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //Output: [8,9,9,9,0,0,0,1]

        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode result2 = addTwoNumbers(l3, l4);
        System.out.println(result2.val); // 8

        // Input: l1 = [0], l2 = [0]
        //Output: [0]

        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(0);

        ListNode result3 = addTwoNumbers(l5, l6);
        System.out.println(result3.val); // 0
    }
}
