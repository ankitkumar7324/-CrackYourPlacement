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
    class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode node,int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        if(root == null){
            return 0;
        }
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int minindex = q.peek().index;
            int first = 0;
            int last = 0;
            for(int i=0;i<size;i++){
                Pair it = q.remove();
                TreeNode temp = it.node;
                int curr_id = it.index-minindex;
                if(i==0) first = curr_id;
                if(i==size-1) last = curr_id;
                if(temp.left != null){
                    q.add(new Pair(temp.left,2*curr_id+1));
                }
                if(temp.right != null){
                    q.add(new Pair(temp.right,2*curr_id+2));
                }

            }
            ans = Math.max(ans,(last-first+1));
        }
        return ans;
    }
}