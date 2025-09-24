import java.util.*;
public class LCATree{
  public static TreeNode lcat(TreeNode root,TreeNode l,TreeNode r){
      if(root==null) return null;
      if(l==root || r==root){
          return root;
      }
      TreeNode lef=lcat(root.left,l,r);
      TreeNode rig=lcat(root.right,l,r);
    if(lef!=null && rig!=null) return root;
    return lef==null?rig:lef;
  }
  public static void main(String[] args){
      TreeNode root=new TreeNode(8);
      root.left=new TreeNode(4);
      root.right=new TreeNode(3);
      root.left.left=new TreeNode(2);
      root.left.right=new TreeNode(1);
      root.right.left=new TreeNode(9);
      root.right.right=new TreeNode(7);
      root.left.left.left=new TreeNode(6);
      root.right.left.left=new TreeNode(12);
      root.right.left.left.right=new TreeNode(0);
      TreeNode l=root.right.left;
      TreeNode r=root.right.left.left.right;
      System.out.println(lcat(root,l,r).data);
  }
}
