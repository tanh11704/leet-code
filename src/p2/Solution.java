package p2;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        if (l1 == null && l2 == null) {
            return null;
        }

        int val1 = l1 != null ? l1.val : 0;
        int val2 = l2 != null ? l2.val : 0;
        result.val = val1 + val2;

        if (result.val >= 10) {
            result.val = result.val % 10;
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else {
                l1.next.val++;
            }
        }

        ListNode next1 = l1 != null ? l1.next : null;
        ListNode next2 = l2 != null ? l2.next : null;
        result.next = addTwoNumbers(next1, next2);

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = new Solution().addTwoNumbers(l1, l2);
        result.printList();
    }
}
