class BST{
  public class Node{
      private int value;
      private int height;
      private Node left;
      private Node right;
      public Node(int value){
          this.value=value;
      }
      public int getValue(){
          return value;
      }
  }
  private Node root;
  public BST(){
  }
  public void insert(int value){
       root= insert(value,root);
  }
  private Node insert(int value,Node node){
    if(node==null){
      node=new Node(value);
      return node;
    }
    if(value<node.getValue()){
      node.left=insert(value,node.left);
    }
    if(value>node.getValue()){
      node.right=insert(value,node.right);
    }
    node.height=Math.max(height(node.left),height(node.right))+1;
    return node;
  }
  public int height(Node node){
    if(node==null){
      return -1;
    }
    return node.height;
  }
  public boolean isEmpty(){
    return root==null;
  }
  public void display(){
    display(root,"Root is:");
  }
  private void display(Node node,String details){
    if(node==null) return;
    System.out.println(details+" "+node.getValue());
    display(node.left,node.getValue()+" Left Child is:");
    display(node.right,node.getValue()+" Right Child is:"):
  }
  public void populate(int[] nums){
      for(int i=0;i<nums.length;i++){
        insert(nums[i]);
      }
  }
}
public class BinarySearch{
  public static void main(String[] args){
      BST bst=new BST();
      int[] arr={8,5,6,7,4,3,9,11,10};
      bst.populate(arr);
      bst.display();
  }
}
