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
    public int heightoftree(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = heightoftree(root.left);
        int rh = heightoftree(root.right);
        return (1+Math.max(lh,rh));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lh = heightoftree(root.left);
        int rh = heightoftree(root.right);
        if(Math.abs(lh-rh)>1) return false;

        boolean lefttree = isBalanced(root.left);
        boolean righttree = isBalanced(root.right);

        if(!lefttree || !righttree) return false;
        return true;
    }
}