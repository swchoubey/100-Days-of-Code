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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(l1, root1);
        dfs(l2, root2);

        if(l1.equals(l2))  
            return true;
        else
            return false;
    }
    public void dfs(List<Integer> l, TreeNode node){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            l.add(node.val);
            return;
        }
        else{
            dfs(l, node.left);
            dfs(l, node.right);
        }
    }
}