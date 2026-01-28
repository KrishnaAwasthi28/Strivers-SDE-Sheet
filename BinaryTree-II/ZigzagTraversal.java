import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            LinkedList<Integer> sub=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(level%2!=0) sub.addFirst(node.data);
                else sub.addLast(node.data);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            level++;
            res.add(sub);
        }
        return res;
    }
}
