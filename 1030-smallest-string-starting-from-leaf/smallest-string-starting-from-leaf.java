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
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, new StringBuilder(), sb);

        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder path, StringBuilder sb){
        if(root == null) return;

        path.append((char)('a' + root.val));

        if(root.left == null && root.right == null){
            String curr = path.reverse().toString();

            if(sb.length() == 0 || curr.compareTo(sb.toString()) < 0){
                sb.setLength(0);
                sb.append(curr);
            }

            path.reverse();
        }

        dfs(root.left, path, sb);
        dfs(root.right, path, sb);

        path.setLength(path.length() - 1);
    }
}