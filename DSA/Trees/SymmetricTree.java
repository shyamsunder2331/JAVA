import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.val=data;
	}
}
public class SymmetricTree{
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(3);
		root.left.left.left=new TreeNode(5);
		root.right.right.right=new TreeNode(5);
		System.out.println(symTree(root));
	}
	public static boolean symTree(TreeNode root){
		Queue<TreeNode> q=new LinkedList<>();
		q.offer(root.left);
		q.offer(root.right);
		boolean flag=true;
		while(!q.isEmpty()){
			TreeNode l=q.poll();
			TreeNode r=q.poll();
			if(l==null && r==null){
				continue;
			}
			if(l==null || r==null){
				flag=false;
				break;		
			}
			if(l.val!=r.val){
				flag=false;
				break;
			}
			q.offer(l.left);
			q.offer(r.right);
			q.offer(l.right);
			q.offer(r.left);
		}
		return flag;
	}
}