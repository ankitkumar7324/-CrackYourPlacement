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
    public TreeNode markparent(TreeNode root , HashMap<TreeNode,TreeNode> childparent,int start){
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode res = new TreeNode(-1);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp.val == start){
                res = temp;
            }
            if(temp.left!=null){
                childparent.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                childparent.put(temp.right,temp);
                q.add(temp.right);
            }
        }
        return res;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> childparent = new HashMap<>();
        TreeNode target = markparent(root,childparent,start);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode current = q.remove();
                if(current.left!=null && visited.get(current.left)==null){
                    visited.put(current.left,true);
                    q.add(current.left);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    visited.put(current.right,true);
                    q.add(current.right);
                }
                if(childparent.get(current)!=null && visited.get(childparent.get(current))==null){
                    visited.put(childparent.get(current),true);
                    q.add(childparent.get(current));
                }
            }
            time++;
        }
        return time-1;
    }
}