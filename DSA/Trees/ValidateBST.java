import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data=data;
    }
}
public class ValidateBST{
    public static boolean helper(TreeNode root,Integer low,Integer high){
      if(root==null) return true;
      if(low!=null && root.data<=low) return false;
      if(high!=null && root.data>=high) return false;
      boolean lTree=helper(root.left,low,root.data);
      boolean rTree=helper(root.right,root.data,high);
      return lTree && rTree;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(8);
        root.right=new TreeNode(13);
        root.left.left=new TreeNode(7);
        root.left.right=new TreeNode(9);
        root.right.left=new TreeNode(12);
        root.right.right=new TreeNode(15);
        root.right.left.left=new TreeNode(11);
        System.out.println(helper(root,null,null));
    }
}
        
