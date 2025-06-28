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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(temp1!=null || temp2!=null || carry!=0){
            int sum = carry;
            if(temp1!=null)
            {
                sum+=temp1.val;
                temp1 = temp1.next;
            }
            if(temp2!=null){
                sum+=temp2.val; 
                temp2 = temp2.next;
            }
            ListNode newnode = new ListNode(sum%10);
            carry = sum/10;
            dummy.next = newnode;
            dummy = dummy.next;
            
        }
        return curr.next;
        // ListNode ans = new ListNode(-1);
        // ListNode finans = ans;
        // int carry = 0;
        // int sum = 0;
        // while(temp1!=null || temp2!=null || carry!=0){
        //     sum = carry;
        //     if(temp1!=null){
        //         sum+=temp1.val;
        //         temp1 = temp1.next;
        //     }
        //     if(temp2!=null){
        //         sum+=temp2.val;
        //         temp2 = temp2.next;
        //     }
        //     carry = sum/10;
        //     int rem = sum%10;
        //     finans.next = new ListNode(rem);
        //     finans = finans.next;
        // }
        // return ans.next;
        // while(temp1!=null){
        //     val = val*10+temp1.val;
        //     temp1 = temp1.next;
        // }
        // while(temp2!=null){
        //     val2 = val2*10+temp2.val;
        //     temp2 = temp2.next;
        // }
        // long rev = 0;
        // long rev2 = 0;
        // while(val!=0){
        //     int rem = (int)val%10;
        //     rev = rev*10+rem;
        //     val/=10;
        // }
        // while(val2!=0){
        //     int rem = (int)val2%10;
        //     rev2 = rev2*10+rem;
        //     val2/=10;
        // }
        // long add = rev + rev2;
        // System.out.print(add);
        // if(add==0){
        //     return new ListNode(0);
        // }
        // //int cnt =0;
        // ListNode ans = new ListNode(-1);
        // ListNode finans = ans;
        // while(add>0){
        //     int rem = (int)add%10;
        //     finans.next = new ListNode(rem);
        //     finans = finans.next;
        //     add/=10;
        // }
        // //System.out.print(cnt);
        // return ans.next;
    }
}