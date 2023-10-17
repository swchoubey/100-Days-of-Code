class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree=new int[n];
        for(int i=0;i<n;i++){
            int left=leftChild[i];
            int right=rightChild[i];
            if(left!=-1){
                inDegree[left]++;
                if(inDegree[left]>1) return false;
            }
            if(right!=-1){
                inDegree[right]++;
                if(inDegree[right]>1)return false;
            }
        }
        int rootCount=0;
        int rootNode=-1;
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                rootCount++;
                rootNode=i;
            }
            if(rootCount>1)return false;

        }
        if(rootCount==0)return false;
        return dfs(rootNode, leftChild, rightChild, inDegree, n)==n;
    }
    private int dfs(int node,int[] leftChild, int[] rightChild, int[] inDegree, int n){
        if(node==-1)return 0;
        inDegree[node]--;
        return 1+dfs(leftChild[node], leftChild, rightChild, inDegree, n)+dfs(rightChild[node],leftChild,rightChild,inDegree,n);
    }
}