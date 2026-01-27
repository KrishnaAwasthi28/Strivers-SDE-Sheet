import java.util.*;
class PostOrderTraversal {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        postOrder(root,res);
        return res;
    }
    public void postOrder(TreeNode root,List<Integer> res){
        if(root==null) return;
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.data);
    }
}
