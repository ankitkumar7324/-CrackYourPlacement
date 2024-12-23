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
 import java.util.*;
 class Tuple{
    TreeNode Node;
    int row;
    int col;

    public Tuple(TreeNode Node , int row , int col){
        this.Node = Node;
        this.row = row;
        this.col = col;
    }

 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        TreeMap<Integer , TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        while(!q.isEmpty())
        {
            Tuple tuple = q.remove();
            TreeNode node = tuple.Node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x))
            {
                map.put(x,new TreeMap<>());
            } 
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y,new PriorityQueue<>());
            }

            map.get(x).get(y).add(node.val);

            if(node.left != null)
            {
                q.add(new Tuple(node.left , x-1 , y+1));
            }
            if(node.right != null)
            {
                q.add(new Tuple(node.right , x+1 , y+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys : map.values())
        {
            List<Integer> column = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : ys.values())
            {
                while(!nodes.isEmpty())
                {
                    column.add(nodes.poll());
                }
            }
            ans.add(column);
        }
        return ans;
    }
}