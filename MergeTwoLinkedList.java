public class MergeTwoLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode mergedList = newHead;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                mergedList.next = list1;
                list1 = list1.next;
            }
            else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }
        if(list1!=null)
        mergedList.next = list1;
        else mergedList.next = list2;
        return newHead.next;
    }
}
