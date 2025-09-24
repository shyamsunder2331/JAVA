import java.util.*;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data=data;
	}
}
class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){
		this.val=val;
	}
}
public class FlatTree{
	public static void Flatten(TreeNode root,Queue<TreeNode> q){
		if(root==null){
			return;
		}
		q.offer(root);
		Flatten(root.left,q);
		Flatten(root.right,q);
	}
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
		Queue<TreeNode> q=new LinkedList<>();
		Flatten(root,q);
		while(!q.isEmpty()){
			System.out.println(q.peek().data);
		}
		
		ListNode list=new ListNode(q.poll().data);
		ListNode dummy=list;
		while(!q.isEmpty()){
			dummy.next=new ListNode(q.poll().data);
			dummy=dummy.next;
		}
		while(list!=null){
			System.out.print(list.val);
			list=list.next;
		}
	}
}