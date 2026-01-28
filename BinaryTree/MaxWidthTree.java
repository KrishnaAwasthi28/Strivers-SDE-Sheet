import java.util.Deque;
import java.util.LinkedList;

public class MaxWidthTree {
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
    public class CustomNode{
        TreeNode node;
        int index;
        CustomNode(TreeNode node,int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=Integer.MIN_VALUE;
        Deque<CustomNode> q=new LinkedList<>();
        q.offer(new CustomNode(root,0));
        while(!q.isEmpty()){
            int level=q.size();
            int stIdx=q.peekFirst().index;
            int lastIdx=q.peekLast().index;
            maxWidth=Math.max(maxWidth,lastIdx-stIdx+1);
            for(int i=0;i<level;i++){
                CustomNode cNode=q.pop();
                int idx=cNode.index;
                TreeNode node=cNode.node;
                if(node.left!=null) q.offer(new CustomNode(node.left,2*idx+1));
                if(node.right!=null) q.offer(new CustomNode(node.right,2*idx+2));
            }
        }
        return maxWidth;
    }
}
