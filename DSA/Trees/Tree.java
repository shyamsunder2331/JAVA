import java.util.*;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data=data;
	}
}
public class Tree{
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		print(root);
	}
	public static void  print(TreeNode root){
		if(root==null){
			return;
		}
		print(root.left);
		System.out.println(root.data);
		print(root.right);
	}
}