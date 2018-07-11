/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        if(lists.length == 1)
             return lists[0];
        ListNode l1 = lists[0];
        for(int i = 1; i < lists.length; i++) {
            ListNode l2 = lists[i];
            l1 = mergeTwoLists(l1, l2);
        }
        return l1;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode itr = newHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                itr.next = l1;
                itr = l1;
                l1 = l1.next;
            } else {
                itr.next = l2;
                itr = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            itr.next = l1;
        } else {
            itr.next = l2;
        }
        return newHead.next;
    }
    
}
