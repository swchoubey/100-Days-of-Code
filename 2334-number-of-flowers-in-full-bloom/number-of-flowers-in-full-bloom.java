class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n=flowers.length;
        int m=people.length;
        int[] beginBloom=new int[n];
        int[] stopBloom=new int[n];
        for(int i=0;i<n;i++){
            beginBloom[i]=flowers[i][0];
            stopBloom[i]=flowers[i][1];
        }
        Arrays.sort(beginBloom);
        Arrays.sort(stopBloom);
        int[] arr=new int[m];
        for(int i=0;i<m;i++){
            int target=people[i];
            int open=binarySearchUpper(beginBloom,target);
            int close=binarySearchLower(stopBloom,target);
            arr[i]=open-close;
        }
        return arr;
    }
    private int binarySearchUpper(int[] arr, int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<=target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
    private int binarySearchLower(int[] arr, int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }

}