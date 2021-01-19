import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Post {
    public static boolean verifyPostorder3(int[] postorder) {
        if(postorder == null || postorder.length <=0) return false;
        return recur(postorder, 0, postorder.length-1);
    }

    private static boolean  recur(int[] postorder, int left ,int right){
        if(left == right) return true;
        int root = postorder[right];
        int index =-1;
        for(int i=left; i < right; i++){
            if(postorder[i] > root){
                index = i;
                break;
            }

        }
        if(index == -1) return recur(postorder,left, right-1); //无右子树
        for(int i=index+1; i < right; i++){
            if(postorder[i] < root) return false;
        }
        if(index == 0) return recur(postorder, index, right-1);//无左子树
        return recur(postorder,left, index-1) && recur(postorder, index, right-1);
    }

    public static void main(String[] args){
        int[] nums = {1,2,5,10,6,9,4,3};
        boolean ret = verifyPostorder(nums);
        System.out.println(ret);

        List<String> list = new ArrayList<>();
        list.add("liu");
        list.add("kang");
        list.add("yu");
        //ReentrantLock
        //String[] arr = (String[])list.toArray();
        String[] arr2 = list.toArray(new String[list.size()]);
        //System.out.println((String) arr[0]);
        System.out.println(arr2[1]);
        String[] array = {"beijing", "shanghai", "hangzhou"};
        List list2 = Arrays.asList(array);
        list2.add("ch");
    }

    /**
     * 判断一个序列是否二叉树前序遍历
     * 分治 + 递归
     * @param preorder
     * @return
     */
    public static boolean verifyPreorder2(int [] preorder){
        return verifyPreorder(preorder, 0, preorder.length-1);
    }

    private static boolean verifyPreorder(int[] preorder, int left, int right){
        if(left >= right) return true;
        //前序遍历最左侧时root
        int i = left;
        for(;i < right; i++){
            if(preorder[i] > preorder[left]) break;
        }
        int mid = i;
        for(;i<right;i++){
            if(preorder[i] < preorder[left]) return false;
        }

        return verifyPreorder(preorder, left+1, mid-1)/*左子树*/ && verifyPreorder(preorder, mid, right)/*右子树*/;
    }

    /**
     * 判断一个序列是否是二叉树前序遍历
     * 辅助栈
     * @param preorder
     * @return
     */
    public static boolean verifyPreorder(int[] preorder){
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i=0; i < preorder.length; i++){
            if(preorder[i] > root) return false;
            while(!stack.isEmpty()){
                if(stack.peek() > preorder[i])
                    root = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return false;
    }

    public static boolean verifyPostorder(int[] postorder){
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i=0; i < postorder.length; i++){
            if(postorder[i] > root) return false;
            while(stack.isEmpty() || stack.peek() > postorder[i]){
               stack.add(postorder[i]);
            }

        }
        return false;
    }

    /**
     * 前序遍历
     * 递归
     */
    public static List<Integer> preorderTravel(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preorderTravel(root, list);
        return list;
    }

    private static void preorderTravel(TreeNode root, List<Integer> ret){
        if(root == null) return;
        ret.add(root.val);
        preorderTravel(root.left, ret);
        preorderTravel(root.right, ret);
    }


    /**
     * 前序遍历
     * 辅助栈
     */
    public static List<Integer> preorderTravel2(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if(root == null) return  ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ret.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return ret;
    }

    /**
     *输出二叉树节点和为sum的所有路径
     * 本质：二叉树的遍历
     */
    public static List<List<Integer>> sumPath(TreeNode root, int sum){
        return null;
    }

    private static void sumPath(TreeNode root, int sum, List<List<Integer>> ret, List<Integer> path){
        if(root == null){
            int tmpSum = 0;
            for(int val : path){
                tmpSum += val;
            }
            //if(tmpSum == sum) ret.add(Collections.co);
            return;
        }
        path.add(root.val);
        sumPath(root.left, sum, ret, path);
        sumPath(root.right, sum, ret, path);
    }


    //路径path和   双递归
    int pathSum3(TreeNode root, int target){
       if(root == null) return 0;
       return pathCount(root, target) + pathSum3(root.left,target) + pathSum3(root.right,target);
    }

    int pathCount(TreeNode root, int target){
        if(root == null){
            return 0;
        }
        int result = 0;
        target = target - root.val;
        if(target == 0){
            result++;
        }
        return  result + pathCount(root.left, target) + pathCount(root.right,target);
    }

    /*
    [1,2,2]
    []
    [1]
    [1,2]
    [1,2,2]

     */




}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}