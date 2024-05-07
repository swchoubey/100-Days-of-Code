/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int carry = 0;
    public void helper(ListNode head){
        if(head == null)
            return;
        helper(head.next);
        int curr = 2 * head.val + carry;
        carry = curr/10;

        head.val = curr % 10;
    }
    public ListNode doubleIt(ListNode head) {
        carry = 0;
        helper(head);

        return (carry == 0)? head : new ListNode(carry, head);
    }
}