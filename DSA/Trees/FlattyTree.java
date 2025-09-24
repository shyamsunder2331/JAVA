import java.util.*;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data=data;
	}
}
public class FlattyTree{
	public static void Flatty(TreeNode root){
		if(root==null) return;
		Flatty(root.left);
		Flatty(root.right);
		if(root.left!=null){
			TreeNode temp=root.right;
			root.right=root.left;
			root.left=null;
			TreeNode curr=root.right;
			while(curr.right!=null){
				curr=curr.right;
			}
			curr.right=temp;
		}
	}
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		
		Flatty(root);
		Queue<TreeNode> q=new LinkedList<>();
		q.offer(root);
		List<List<Integer>> list=new ArrayList<>();
		while(!q.isEmpty()){
			int levelSize=q.size();
			List<Integer> currList=new ArrayList<>();
			for(int i=0;i<levelSize;i++){
				TreeNode temp=q.peek();
				currList.add(q.poll().data);
				if(temp.left!=null) q.offer(temp.left);
				if(temp.right!=null) q.offer(temp.right);
			}
			list.add(currList);
		}
				
		for(List<Integer> i:list){
			for(Integer j:i){
				System.out.print(j+" ");
			}
		}
	}
}