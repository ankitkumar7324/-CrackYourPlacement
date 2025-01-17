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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return new ArrayList<>();
        }
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            ans.add(q.peek().val);
            for(int i=0;i<len;i++){
                TreeNode temp = q.poll();
                if(temp.right!=null){
                    q.add(temp.right);
                } 
                if(temp.left!=null){
                    q.add(temp.left);
                }
                
            }
        }
        return ans;
    }
}