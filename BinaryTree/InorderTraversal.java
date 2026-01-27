import java.util.ArrayList;
import java.util.List;

class InorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root,List<Integer> res){
        if(root==null) return;
        inorder(root.left,res);
        res.add(root.data);
        inorder(root.right,res);
    }

}
