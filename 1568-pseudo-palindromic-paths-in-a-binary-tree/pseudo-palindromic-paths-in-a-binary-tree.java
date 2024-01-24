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
    public int pseudoPalindromicPaths (TreeNode root) {
        return countPaths(root, 0);
    }
    private int countPaths(TreeNode node, int path){
        if(node == null){
            return 0;
        }

        path ^= (1 << node.val);

        if(node.left == null && node.right == null){
            return (path & (path - 1)) == 0? 1 : 0;
        }

        return countPaths(node.left, path) + countPaths(node.right, path);
    }
}