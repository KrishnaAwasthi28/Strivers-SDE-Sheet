import java.util.*;
class PreorderTraversal {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.data);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}