import java.util.*;
class Segment{
  public class Node{
    int data;
    int startInterval;
    int endInterval;
    Node left;
    Node right;
    public Node(int startInterval,int endInterval){
      this.startInterval=startInterval;
      this.endInterval=endInterval;
    }
  }
  private Node root;
  public Segment(){}
  public void display(){
    Queue<Node> q=new LinkedList<>();
    q.offer(root);
    List<List<Node>> res=new ArrayList<>();
    while(!q.isEmpty()){
      int lSize=q.size();
      List<Node> currL=new ArrayList<>();
      for(int i=0;i<lSize;i++){
        Node temp=q.poll();
        currL.add(temp);
        if(temp.left!=null) q.offer(temp.left);
        if(temp.right!=null) q.offer(temp.right);
      }
      res.add(currL);
    }
    for(List<Node> i:res){
      for(Node j:i){
        System.out.print(j.data+"-> ( "+j.startInterval+","+j.endInterval+" )  ");
      }
      System.out.println();
    }
  }
  public void update(int index,int updatedValue){
    if(index<root.startInterval || index>root.endInterval){
      System.out.println("Cannot be updated");
      return;
    }
    root.data=update(root,index,updatedValue);
  }
  public int update(Node node,int index,int uValue){
    if(node.startInterval<=index && node.endInterval>=index){
      if(index==node.startInterval && index==node.endInterval){
        node.data=uValue;
        return node.data;
      }else{
       int lAns=update(node.left,index,uValue);
        int rAns=update(node.right,index,uValue);
        node.data=lAns+rAns;
        return node.data;
    }
    }
    return node.data;
  }
  public int query(int qstart,int qend){
    if(qstart<0 || qend>root.endInterval){
      return -1;
    }
    return query(root,qstart,qend);
  }
  public int query(Node root,int qstart,int qend){
      if(root.startInterval>=qstart && root.endInterval<=qend){
        return root.data;
      }else if(root.startInterval>qend || root.endInterval<qstart){
        return 0;
      }
      return this.query(root.left,qstart,qend)+this.query(root.right,qstart,qend);
  }
  public void constructTree(int[] nums){
    root=constructTree(nums,0,nums.length-1);
  }
  public Node constructTree(int[] nums,int start,int end){
    if(start==end){
      Node leaf=new Node(start,end);
      leaf.data=nums[start];
      return leaf;
    }
    Node node=new Node(start,end);
    int mid=start+(end-start)/2;
    node.left=this.constructTree(nums,start,mid);
    node.right=this.constructTree(nums,mid+1,end);
    node.data=node.left.data+node.right.data;
    return node;
}
}
public class Main{
  public static void main(String[] args){
      Segment segment=new Segment();
      int[] arr={3,1,5,-2,4,7,6,67};
      segment.constructTree(arr);
      segment.display();
    //   System.out.println(segment.query(2,7));
      segment.update(3,54);
      
      
      segment.update(3,9);
      segment.update(7,8);
      segment.display();
      System.out.println(segment.query(3,5));
      
  }
  
}
