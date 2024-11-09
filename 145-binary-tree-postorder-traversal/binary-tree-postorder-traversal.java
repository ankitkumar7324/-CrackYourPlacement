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
    public static void post(TreeNode root , ArrayList<Integer> postorder){
        if(root == null){
            return;
        }
        post(root.left,postorder);
        post(root.right,postorder);
        postorder.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorder = new ArrayList<>();
        post(root,postorder);
        return postorder;
    }
}