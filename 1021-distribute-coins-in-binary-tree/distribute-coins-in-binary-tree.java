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
    public int distributeCoins(TreeNode root) {
        TreeNode temp = new TreeNode();
        return dfs(root, temp);
    }
    public int dfs(TreeNode curr, TreeNode parent){
        if(curr == null) return 0;
        int moves = dfs(curr.left, curr) + dfs(curr.right, curr);
        int from = curr.val - 1;
        parent.val += from;
        moves += Math.abs(from);

        return moves;
    }
}