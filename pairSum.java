public class pairSum {
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode nextNode, prev = null;
        while(slow!=null){
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        ListNode start = head;
        int maxSum = 0;
        while(prev != null){
            maxSum = Math.max(maxSum, start.val + prev.val);
            prev = prev.next;
            start = start.next;
        }
        return maxSum;
    }
}
