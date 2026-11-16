class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        if(list1!=null)
            minHeap.offer(list1);
        if(list2!=null)
            minHeap.offer(list2);

        while(!minHeap.isEmpty())
        {
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            if(smallest.next!=null)
                minHeap.offer(smallest.next);
        }
            
        return dummy.next;
    }
}