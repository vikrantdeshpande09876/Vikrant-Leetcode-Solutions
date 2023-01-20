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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Move fast pointer ahead by n-1
        // Iterate slow & fast ptrs, until fast pointer reaches null
        // If prev==null, head = head->next
        // else prev->next = slow->next
        ListNode prev=null, slow=head, fast=head;
        while (n-- > 1)
            fast = fast.next;

        while (fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null)
            head = head.next;
        else
            prev.next = slow.next;
        return head;
    }
}