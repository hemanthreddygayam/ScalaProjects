import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Hemanth on 8/28/2017.
 */

class Node{
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int data)
    {
      this.val = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
public class PopulateNextPointers {

    public static void PopulateNextPointers(Node root)
    {

        if(root == null)
        return ;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (! queue.isEmpty())
        {
            int size = queue.size();
            Node temp = null;
            Node prev = null;
            while(size > 0)
            {
                size = size -1;
                temp = queue.remove();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                queue.add(temp.right);
                if(prev != null) {
                    prev.next = temp;
                }
                prev = temp;


            }
            temp.next = null;
        }

    }

}
