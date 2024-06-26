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
    private List<TreeNode> sortedArr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);

        return sortedArr(0, sortedArr.size() - 1);
    }

    private void inOrderTraversal(TreeNode root){
        if(root == null) return;

        inOrderTraversal(root.left);
        sortedArr.add(root);
        inOrderTraversal(root.right);
    }

    private TreeNode sortedArr(int start, int end){
        if(start > end) return null;

        int mid = (start + end)/2;

        TreeNode root = sortedArr.get(mid);
        root.left = sortedArr(start, mid - 1);
        root.right = sortedArr(mid + 1, end);

        return root;
    }
}