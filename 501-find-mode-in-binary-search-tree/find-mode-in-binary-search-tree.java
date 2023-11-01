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
    private Map<Integer, Integer> map = new HashMap<>();
    private int maxFrequency=0;
    public int[] findMode(TreeNode root) {
        List<Integer> modesList=new ArrayList<>();
        if(root == null){
            return new int[0];
        }
        inOrderTraversal(root);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==maxFrequency){
                modesList.add(entry.getKey());
            }
        }
        int[] modesArr=new int[modesList.size()];
        for(int i=0;i<modesList.size();i++){
            modesArr[i]=modesList.get(i);
        }

        return modesArr;
    }
    private void inOrderTraversal(TreeNode node){
        if(node!=null){
            inOrderTraversal(node.left);
            int frequency=map.getOrDefault(node.val,0)+1;
            map.put(node.val,frequency);
            maxFrequency=Math.max(maxFrequency,frequency);

            inOrderTraversal(node.right);
        }
    }
}