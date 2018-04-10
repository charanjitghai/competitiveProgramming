/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    
    private int getMinNodeIdx(ListNode[] lists) {
        
        int minNodeIdx = -1;
        for(int idx = 0; idx < lists.length; idx++) {
            ListNode node = lists[idx];
            if(node != null && (minNodeIdx == -1 || node.val < lists[minNodeIdx].val)) {
                minNodeIdx = idx;
            }
        }
        return minNodeIdx;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new ListNodeComparator());
        
        for(int idx = 0; idx < lists.length ; idx++) {
            if(lists[idx] != null) {
                pq.add(lists[idx]);
            }
        }
    
        ListNode ans = pq.poll();
        if(ans != null && ans.next != null)
            pq.add(ans.next);
    
        ListNode cur = ans;
        while(pq.peek() != null) {
            ListNode min = pq.poll();
            cur.next = min;
            cur = cur.next;
            if(min.next != null)
                pq.add(min.next);
        }
    
        return ans;
    }
}

class ListNodeComparator implements Comparator<ListNode> {
    
    // override compare to sort list nodes based on val in increasing order
    public int compare (ListNode n1, ListNode n2) {
        return n1.val - n2.val;
    }
}