//*******************23. Merge k Sorted Lists
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
    
    // using PriorityQueue
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
    // merge two sorted array
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
