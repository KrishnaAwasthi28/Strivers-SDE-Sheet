public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode findNthNode(ListNode temp,int k){
        int count=1;
        while(temp!=null){
            if(count==k) return temp;
            count++;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int size=1;
        ListNode temp=head;
        while(temp.next!=null){
            size++;
            temp=temp.next;
        }
        if(k%size==0) return head;
        k=k%size;
        temp.next=head;
        ListNode newTail=findNthNode(head,size-k);
        head=newTail.next;
        newTail.next=null;
        return head;
    }
}
