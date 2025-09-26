class AVL{
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
      public int getHeight(){
        return height;
      }
    }
  private Node root;
  public AVL(){}
  public int height(Node node){
    if(node==null) return -1;
    return node.height;
  }

  public void populate(int[] nums){
    for(int i=0;i<nums.length;i++){
      insert(nums[i]);
    }
  }
  public void display(){
    display(root,"Root is:");
  }

  private void display(Node node,String details){
    if(node==null) return;
    System.out.println(details+" "+ node.getValue()+" "+node.getHeight());
    display(node.left,"Left child of "+node.getValue()+" is :");
    display(node.right,"Right child of "+node.getValue()+" is :");
  }
  public boolean isBalanced(){
    return isBalanced(root);
  }
  
  public boolean isBalanced(Node node){
    if(node==null) return true;
    return (Math.abs(height(node.left))-Math.abs(height(node.right))<=1) && isBalanced(node.left) && isBalanced(node.right);
  }
  public void insert(int data){
   root= insert(data,root);
  }
  
  private Node insert(int data,Node node){
    if(node==null){
      Node newNode=new Node(data);
      return newNode;
    }
    if(node.value>data){
      node.left=insert(data,node.left);
    }
    if(node.value<data){
      node.right=insert(data,node.right);
    }
    node.height=Math.max(height(node.left),height(node.right))+1;
    return rotate(node);
  }

  public Node rightRotate(Node node){
    Node c=node.left;
    Node t=c.right;
    c.right=node;
    node.left=t;
    node.height=Math.max(height(node.left),height(node.right))+1;
    c.height=Math.max(height(c.left),height(c.right))+1;
    return c;
  }
  public Node leftRotate(Node node){
    Node c=node.right;
    Node t=c.left;
    c.left=node;
    node.right=t;
    node.height=Math.max(height(node.left),height(node.right))+1;
    c.height=Math.max(height(c.left),height(c.right))+1;
    return c;
  }
  
  public Node rotate(Node node){
    if(height(node.left)-height(node.right)>1){  //left heavy
          if(height(node.left.left)-height(node.left.right)>0){  //left-left
              //rightRotate
              return rightRotate(node);
          }
          if(height(node.left.left)-height(node.left.right)<0){  //left-right
              // left rotate the node.left
              //right rotate the parent node
              node.left=leftRotate(node.left);
              return rightRotate(node);
          }
    }
    if(height(node.left)-height(node.right)<-1){  //left heavy
          if(height(node.right.right)-height(node.right.left)>0){  //right-right
              //leftRotate
              return leftRotate(node);
          }
          if(height(node.right.left)-height(node.right.right)>0){  //right-left
              // right rotate the node.left
              //left rotate the parent node
              node.right=rightRotate(node.right);
              return leftRotate(node);
          }
    }
    return node;
  }
}
public class Main{
    public static void main(String[] args){
        AVL avl=new AVL();
        int[] nums={9,7,6,8,5,14,13,15,12};
        avl.populate(nums);
        int[] arr={3,2,1,0,-1,-2,-3};
        avl.populate(arr);
        avl.display();
        System.out.println(avl.isBalanced());
    }
}
