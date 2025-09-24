import java.util.*;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data=data;
	}
}
public class InvertTree{
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
		
		System.out.println(invert(root));
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
			System.out.println();
		}
	}
	public static TreeNode invert(TreeNode node){
		if(node==null) return null;
		TreeNode l=invert(node.left);
		TreeNode r=invert(node.right);
		node.left=r;
		node.right=l;
		return node;
	}
}