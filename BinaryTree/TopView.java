import java.util.*;
public class TopView {
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
    public class CustomNode{
        Node node;
        int col;
        CustomNode(Node node,int col){
            this.node=node;
            this.col=col;
        }
    }
    public ArrayList<Integer> topView(Node root){
        ArrayList<Integer> res=new ArrayList<>();
        Queue<CustomNode> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.offer(new CustomNode(root, 0));
        while(!q.isEmpty()){
            CustomNode custom=q.poll();
            Node node=custom.node;
            int col=custom.col;
            if(!map.containsKey(col)) map.put(col,node.data);
            if(node.left!=null) q.offer(new CustomNode(node.left, col-1));
            if(node.right!=null) q.offer(new CustomNode(node.right, col+1));
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
