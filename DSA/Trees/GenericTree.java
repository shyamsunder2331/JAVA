import java.util.*;
class TreeNode{
	int data;
	ArrayList<TreeNode> child;
	public TreeNode(int data){
		this.data=data;
		child=new ArrayList<>();
	}
}
public class GenericTree{
	static TreeNode root;
	public static void display(TreeNode node){
		System.out.print(node.data+"->");
		for(TreeNode i:node.child){
			System.out.print(i.data+",");
		}
		System.out.println();
		for(TreeNode i:node.child){
			display(i);
		}
	}
	

	public static void main(String[] args){
		int[] arr=new int[]{10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Stack<TreeNode> stack=new Stack<>();
		for(int i=0;i<arr.length;i++){
			if(arr[i]==-1){
				stack.pop();
			}else{
				if(stack.size()>0){
					TreeNode t=new TreeNode(arr[i]);
					stack.peek().child.add(t);
					stack.push(t);
				}else{
					root=new TreeNode(arr[i]);
					stack.push(root);
				}
			}
		}
		display(root);
	}
}