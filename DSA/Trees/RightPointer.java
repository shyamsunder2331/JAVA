import java.util.*;
import java.io.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	public TreeNode(int val){
		this.val=val;
	}
}
public class RightPointer{
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		Queue<TreeNode> q=new LinkedList<>();
		q.offer(root);
		List<List<TreeNode>> list=new ArrayList<>();
		while(!q.isEmpty()){
			int levelSize=q.size();
			List<TreeNode> currList=new ArrayList<>();
			for(int i=0;i<levelSize;i++){
				TreeNode temp=q.poll();
				currList.add(temp);
				if(temp.left!=null) q.offer(temp.left);
				if(temp.right!=null) q.offer(temp.right);
				if(temp==root){
					temp.next=null;
				}
				if(temp.left!=null){
					temp.left.next=temp.right;
					if(temp.right.next==null && temp.next!=null){
						temp.right.next=temp.next.left;
					}
				}
				
				if(i==levelSize-1){
					temp.next=null;
				}
			}
			list.add(currList);
		}
		for(List<TreeNode> i:list){
			for(TreeNode j:i){
				System.out.print(j.val+" ");
			}
			System.out.println();
		}
		for(List<TreeNode> i:list){
			TreeNode temp=i.get(0);
			while(temp!=null){
				System.out.print(temp.val+" ");
				temp=temp.next;
			}
		System.out.println();
		}
	}		
}