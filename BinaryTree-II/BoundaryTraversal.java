import java.util.*;
class BoundaryTraversal {
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
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList <Integer> res = new ArrayList<Integer>();
	    // insert the root
	    if(!isLeaf(root)){
	        res.add(root.data);
	    }
	    //left boundary
	    insertLeft(res,root);
	    // leaf
	    insertLeaf(res,root);
	    //right boundary
	    insertRight(res,root);
	    return res;
        
    }
    
    public boolean isLeaf(Node node){
        return(node.left==null&& node.right==null);
    }
    
    public void insertLeft(ArrayList<Integer> res,Node root){
        Node node=root.left;
        while(node!=null){
            if(isLeaf(node)) break;
            res.add(node.data);
            if(node.left!=null) node=node.left;
            else node=node.right;
        }
    }
    
    public void insertRight(ArrayList<Integer> res,Node root){
        Node rightNode=root.right;
        Stack<Integer> st=new Stack<>();
        while(rightNode!=null){
            if(isLeaf(rightNode)) break;
            st.push(rightNode.data);
            if(rightNode.right!=null) rightNode=rightNode.right;
            else rightNode=rightNode.left;
        }
        while(st.size()>0) res.add(st.pop());
    }
    
    public void insertLeaf(ArrayList<Integer> res,Node root){
        if(root==null) return;
        insertLeaf(res,root.left);
        insertLeaf(res,root.right);
        if(isLeaf(root)) res.add(root.data);
    }
}
