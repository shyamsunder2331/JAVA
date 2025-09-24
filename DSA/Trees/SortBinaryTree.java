import java.util.*;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data=data;
	}
}
public class SortBinaryTree{
	public static TreeNode convertTree(int[] arr,int start,int end){
		if(start>end) return null;
		int mid=start+(end-start)/2;
		TreeNode root=new TreeNode(arr[mid]);
		root.left=convertTree(arr,start,mid-1);
		root.right=convertTree(arr,mid+1,end);
		return root;	
	}
	public static void main(String[] args){
		int[] arr={1,2,3,4,5,6,7};
		TreeNode root=convertTree(arr,0,arr.length-1);
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
}