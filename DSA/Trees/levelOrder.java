import java.util.*;
class TreeNode{
	int data;
	TreeNode left,right;
	public TreeNode(int data){
		this.data=data;
	}
}
public class levelOrder{
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		List<List<Integer>> res=levelWise(root);
		for(List<Integer> i:res){
			for(Integer j:i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> levelWise(TreeNode root){
		List<List<Integer>> ans=new ArrayList<>();
		Queue<TreeNode> q=new ArrayDeque<>();
		q.offer(root);
		while(!q.isEmpty()){
			int sz=q.size();
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<sz;i++){
				TreeNode temp=q.poll();
				if(temp.left!=null) q.offer(temp.left);
				if(temp.right!=null) q.offer(temp.right);
				list.add(temp.data);
			}
			ans.add(list);
		}
		return ans;
	}
}