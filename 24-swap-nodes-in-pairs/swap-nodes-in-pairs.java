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
    public ListNode swapPairs(ListNode head) {
        if(head == null|| head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode check = new ListNode(0);
        ListNode ans = check;
        while(temp!=null && temp.next!=null){
            ListNode first = temp;
            ListNode second = temp.next;
            ans.next = second;
            first.next = second.next;
            second.next = first;
            ans = first;
            temp = first.next;
        }
        return check.next;
    }
    
    
}