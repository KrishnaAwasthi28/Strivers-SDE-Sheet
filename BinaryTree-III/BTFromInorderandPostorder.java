import java.util.HashMap;

class BTFromInorderandPostorder {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length-1;
        int m=inorder.length-1;
        HashMap<Integer,Integer> indexMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        TreeNode root=construct(postorder,inorder,indexMap,0,n,0,m);
        return root;
    }
    public TreeNode construct(int[] postorder,int[] inorder,HashMap<Integer,Integer> indexMap,int postIndStart,int postIndEnd,int inIndStart,int inIndEnd){
        if(postIndStart>postIndEnd || inIndStart>inIndEnd){
            return null;
        }
        int rootData=postorder[postIndEnd];
        int rootIndex=indexMap.get(rootData);
        TreeNode root=new TreeNode(rootData);
        int leftTreeSize=rootIndex-inIndStart;
        int rightTreeSize=inIndEnd-rootIndex;
        root.left=construct(postorder,inorder,indexMap,postIndStart,postIndStart+leftTreeSize-1,inIndStart,rootIndex-1);
        root.right=construct(postorder,inorder,indexMap,postIndStart+leftTreeSize,postIndStart+leftTreeSize+rightTreeSize-1,rootIndex+1,inIndEnd);
        return root;
    }
}