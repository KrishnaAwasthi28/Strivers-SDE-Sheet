import java.util.HashMap;

class BTFromPreorderandInorder {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        int n=preorder.length-1;
        int m=inorder.length-1;
        HashMap<Integer,Integer> indexMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        TreeNode root=construct(preorder,inorder,indexMap,0,n,0,m);
        return root;
    }
    public TreeNode construct(int[] preorder,int[] inorder,HashMap<Integer,Integer> indexMap,int preIndStart,int preIndEnd,int inIndStart,int inIndEnd){
        if(preIndStart>preIndEnd || inIndStart>inIndEnd){
            return null;
        }
        int rootData=preorder[preIndStart];
        int rootIndex=indexMap.get(rootData);
        TreeNode root=new TreeNode(rootData);
        int leftTreeSize=rootIndex-inIndStart;
        int rightTreeSize=inIndEnd-rootIndex;
        root.left=construct(preorder,inorder,indexMap,preIndStart+1,preIndStart+leftTreeSize,inIndStart,rootIndex-1);
        root.right=construct(preorder,inorder,indexMap,preIndStart+leftTreeSize+1,preIndStart+leftTreeSize+rightTreeSize,rootIndex+1,inIndEnd);
        return root;
    }
}
