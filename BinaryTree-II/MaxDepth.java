public class MaxDepth{
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public int maxDepth(Node root){
        if(root==null) return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        int h=1+Math.max(lh,rh);
        return h;
    }
}