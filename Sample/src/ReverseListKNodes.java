/**
 * Created by Hemanth on 8/21/2017.
 */
class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int data)
    {
        this.val = data;
        this.next = null;
    }
}
public class ReverseListKNodes {

    public static ListNode insertIntoListNode(ListNode A,int data){

        ListNode node = A;
        while(node.next != null)
        {
           node = node.next;
        }
        node.next = new ListNode(data);
        return A;

    }


    public static ListNode RecurSiveReverseKNodes(ListNode head,int k)
    {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        int i  = 0;
        while (cur != null && i < k)
        {
            i = i+1;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        if(cur != null)
        {
            head.next = RecurSiveReverseKNodes(cur,k);
        }
        return prev;
    }


    public static ListNode printListReverseKNodes(ListNode A,int k)
    {
        ListNode node = A;
        ListNode head = null;
        int j = 0;
        ListNode curActiveNode = null;
        while(node != null)
        {
            ListNode cur = node;
            ListNode next = null;
            ListNode prev = null;
            int i  = 0;
            while(cur != null && i < k)
            {
                i = i+1;
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            if( j == 0)
            {
                head= prev;
                curActiveNode = head;
            }
            else {

                while(curActiveNode.next != null)
                {
                    curActiveNode = curActiveNode.next;
                }

                curActiveNode.next = prev;
            }

            node = next;

            j++;

        }
        return head;
    }

    public static void printList(ListNode A)
    {
        while (A != null)
        {
            System.out.print(A.val+"->");
            A= A.next;
        }
    }

    public static void main(String[] args)
    {
        ListNode A = new ListNode(8);
        A = insertIntoListNode(A,11);
        A = insertIntoListNode(A,4);
        A = insertIntoListNode(A,12);
        A = insertIntoListNode(A,0);
        A = insertIntoListNode(A,1);
        A = insertIntoListNode(A,20);

        printList(A);

        System.out.println();
        //ListNode s = printListReverseKNodes(A,4);
        ListNode B = RecurSiveReverseKNodes(A,2);
        printList(B);


    }
}


