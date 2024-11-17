public class reorderList {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next, prev = null;
        while(slow!=null){
            next = slow.next;
            slow.next = prev;
            prev = slow; 
            slow = next;
        }
        ListNode start = head;
        while(prev.next!=null){
            ListNode temp = start.next;
            start.next = prev;
            start = temp;
            temp = prev.next;
            prev.next = start;
            prev = temp;
        }
    }
}
