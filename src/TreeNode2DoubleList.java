
import java.sql.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class TreeNode2DoubleList {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

   static Node pre = null;
   static Node head = null;

    public static void dfs(Node cur){
        if(cur == null) return;
        dfs(cur.left);
        if(pre == null){
            head = cur;
        }else {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        dfs(cur.right);
    }

    public static Node treeToDoublyList(Node root){
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public static void main(String[] args){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        treeToDoublyList(root);
        Queue<Integer> q = new LinkedList<>();
        //Array
        List list = new ArrayList();
        list.add(1);
        list.add("1");
        list.add(12.34);
        list.add(new Node(1));
        //Stack
        //ReentrantLock
        //ArrayBlockingQueue
    }

    // 1<=k <=N
    /*int findKth(TreeNode root, int k){


    }
*/
    void recur(TreeNode root, List<Integer> list){
        if(root == null) return;
        recur(root.left, list);
        list.add(root.val);
        recur(root.right, list);
    }

}
