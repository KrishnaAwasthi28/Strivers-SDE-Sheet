import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public List<List<Integer>> allRootToLeaf(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(root,new ArrayList<>(),res);
        return res;
    }
    public void dfs(Node root,List<Integer> path,List<List<Integer>> res){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            res.add(new ArrayList<>(path));
        }else{
            dfs(root.left,path,res);
            dfs(root.right,path,res);
        }
    }
}
