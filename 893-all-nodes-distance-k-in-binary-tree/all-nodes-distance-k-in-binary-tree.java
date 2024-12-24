/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markparent(TreeNode root , HashMap<TreeNode,TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp.left!=null){
                map.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                map.put(temp.right,temp);
                q.add(temp.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> child_parent = new HashMap<>();   //node->parent
        markparent(root,child_parent);  // by levelorder traversal
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        int curr=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr == k) break;
            curr++;
            for(int i=0;i<size;i++){
                TreeNode current = q.remove();
                if(current.left!=null && visited.get(current.left)==null){
                    q.add(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.add(current.right);
                    visited.put(current.right,true);
                }
                if(child_parent.get(current)!=null && visited.get(child_parent.get(current))==null){
                    q.add(child_parent.get(current));
                    visited.put(child_parent.get(current),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            ans.add(temp.val);
        }
        return ans;
    }
}