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
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dfs(root, result);
        return result.toString();
    }
    public static void dfs(TreeNode node, StringBuilder res){
        if(node==null){
            return;
        }
        res.append(String.valueOf(node.val));
        if(node.left == null && node.right == null){
            return;
        }
        res.append('(');
        dfs(node.left, res);
        res.append(')');
        if(node.right != null){
            res.append('(');
            dfs(node.right, res);
            res.append(')');
        }
    }
}