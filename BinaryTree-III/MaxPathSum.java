class MaxPathSum {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public int maxPathSum(TreeNode root) {
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        dfs(root,max);
        return max[0];
    }
    public int dfs(TreeNode root,int[] max){
        if(root==null) return 0;
        int leftPath=Math.max(0,dfs(root.left,max));
        int rightPath=Math.max(0,dfs(root.right,max));
        max[0]=Math.max(max[0],leftPath+rightPath+root.val);
        return root.val+Math.max(leftPath,rightPath);
    }
}