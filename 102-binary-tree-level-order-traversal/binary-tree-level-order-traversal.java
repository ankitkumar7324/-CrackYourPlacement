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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            int cnt = q.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=0;i<cnt;i++){
                TreeNode temp = q.peek();
                sublist.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                q.remove(temp);
            }
            ans.add(sublist);
        }
        return ans;
    }
}