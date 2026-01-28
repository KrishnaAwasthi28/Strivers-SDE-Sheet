
public class SameTree {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data,TreeNode left,TreeNode right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.data==q.data) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
