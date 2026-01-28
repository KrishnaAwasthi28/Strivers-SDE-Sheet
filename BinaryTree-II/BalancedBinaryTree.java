public class BalancedBinaryTree {
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
    public int getHeight(TreeNode root){
        if(root==null) return 0;
        int lh=getHeight(root.left);
        int rh=getHeight(root.right);
        if(lh==-1 || rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root){
        int height=getHeight(root);
        if(height==-1) return false;
        return true;
    }
}
