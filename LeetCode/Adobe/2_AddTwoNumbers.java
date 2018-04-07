/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = null;
        ListNode cur = null;
        
        while(l1 != null || l2 != null){
            
            int operand1 = 0;
            if(l1 != null){
                operand1 = l1.val;
                l1 = l1.next;
            }
            
            int operand2 = 0;
            if(l2 != null){
                operand2 = l2.val;
                l2 = l2.next;
            }
            
            int sum = operand1 + operand2 + carry;
            int result = sum%10;
            carry = sum/10;
            
            if(cur == null){
                cur = new ListNode(result);
                ans = cur;
            }
            else{
                cur.next = new ListNode(result);
                cur = cur.next;
            }
        }
        
        if(carry != 0)
            cur.next = new ListNode(carry);
        
        return ans;
    }
}