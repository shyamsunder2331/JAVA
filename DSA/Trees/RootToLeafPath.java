/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        StringBuilder s=new StringBuilder();
        findPath(root,res,s);
        return res;
    }
    public boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }
    public void findPath(TreeNode node,List<String> res,StringBuilder s){
        if(node==null) return;
        int n=s.length();
        s.append(node.val);
        if(isLeaf(node)){
            res.add(s.toString());
        }else{
        s.append("->");
        findPath(node.left,res,s);
        findPath(node.right,res,s);
        }
        s.setLength(n);
    }
}
