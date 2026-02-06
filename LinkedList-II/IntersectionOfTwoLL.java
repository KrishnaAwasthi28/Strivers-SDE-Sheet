public class IntersectionOfTwoLL {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1=headA;
        ListNode t2=headB;
        int s1=0,s2=0;
        while(t1!=null){
            s1++;
            t1=t1.next;
        }
        while(t2!=null){
            s2++;
            t2=t2.next;
        }
        t1=headA;
        t2=headB;
        if(s1>s2){
            for(int i=0;i<(s1-s2);i++){
                t1=t1.next;
            }
        }
        if(s2>s1){
            for(int i=0;i<(s2-s1);i++){
                t2=t2.next;
            }
        }
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if(t1==null){
                return null;
            }
        }
        return t1;
    }
}
