
public class FlattenBTtoLinkedList {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode curr=root;
        TreeNode rm=null;
        while(curr!=null){
            if(curr.left!=null){
                rm=curr.left;
                while(rm.right!=null){
                    rm=rm.right;
                }
                rm.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
        
    }
}
