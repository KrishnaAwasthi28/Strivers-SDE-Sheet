import java.util.*;
public class VerticalOrder {
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
    TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> map=new TreeMap<>();
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        dfs(root,0,0);
        for(Map.Entry<Integer,TreeMap<Integer,ArrayList<Integer>>> entry:map.entrySet()){
            TreeMap<Integer,ArrayList<Integer>> levelMap=entry.getValue();
            ArrayList<Integer> list=new ArrayList<>();
            for(Map.Entry<Integer,ArrayList<Integer>> subEntry:levelMap.entrySet()){
                ArrayList<Integer> subList=subEntry.getValue();
                Collections.sort(subList);
                list.addAll(subList);
            }
            res.add(list);
        }
        return res;
    }

    public void dfs(Node root,int col,int level){
        if(root==null) return;
        if(!map.containsKey(col)){
            map.put(col,new TreeMap<>());
        }
        if(!map.containsKey(level)){
            map.get(col).put(level,new ArrayList<>());
        }
        map.get(col).get(level).add(root.data);
        if(root.left!=null) dfs(root.left,col-1,level+1);
        if(root.right!=null) dfs(root.right,col+1,level+1);
    }
}
