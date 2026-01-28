
public class Diameter {
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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi=new int[1];
        findHeight(root,maxi);
        return maxi[0];
    }
    public int findHeight(TreeNode root,int[] maxi){
        if(root==null) return 0;
        int lh=findHeight(root.left,maxi);
        int rh=findHeight(root.right,maxi);
        maxi[0]=Math.max(maxi[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}
