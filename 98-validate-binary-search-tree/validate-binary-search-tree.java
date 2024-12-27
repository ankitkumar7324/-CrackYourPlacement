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
    public boolean helper(TreeNode root,Integer sr , Integer lr){
        if(root == null){
            return true;
        }
        if((sr!=null && root.val<=sr) || (lr != null &&root.val>=lr)){
            return false;
        }
        return helper(root.left,sr,root.val) && helper(root.right,root.val,lr);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return helper(root,null,null);
    }
}