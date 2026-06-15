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
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast.next==null){
            return null;
        }
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }
        ListNode dummy = head;
        ListNode temp=dummy;
       while(temp.next!=null){
        if(temp.next==slow){
            temp.next=slow.next;
            break;
        }
        temp=temp.next;
       }
        return dummy;
    }
}