
public class ChildSumInBinaryTree {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public boolean isSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftValue = (root.left != null) ? root.left.data : 0;
        int rightValue = (root.right != null) ? root.right.data : 0;
        if (root.data == leftValue + rightValue
                && isSumProperty(root.left)
                && isSumProperty(root.right)) {
            return true;
        }

        return false;
    }
}
