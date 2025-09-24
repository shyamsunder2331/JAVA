import java.util.*;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data=data;
	}
}
public class HeightTree{
	static int diameter=0;
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		root.left.left.right=new TreeNode(8);
		root.right.right.left=new TreeNode(9);
		System.out.println(height(root)+" "+diameter);
	}
	public static int height(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		int dia=leftHeight+rightHeight+1;
		diameter=Math.max(diameter,dia);
		return Math.max(leftHeight,rightHeight)+1;
	}
}